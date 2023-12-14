package com.viduc.billingcore.repository.sale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.*;
import com.viduc.billingcore.domain.view.*;
import com.viduc.billingcore.dto.components.*;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.dto.response.DteApiProcessingResultResponseDte;
import com.viduc.billingcore.mapper.sale.IDteBodyMapper;
import com.viduc.billingcore.mapper.sale.IDtePaymentMapper;
import com.viduc.billingcore.repository.configuration.ConfigurationRepository;
import com.viduc.billingcore.repository.configuration.DteApiRepository;
import com.viduc.billingcore.utils.enums.DocumentType;
import com.viduc.billingcore.utils.enums.RequestProcessType;
import com.viduc.billingcore.utils.qualifier.TypeElectronicDocument;
import jakarta.ejb.Asynchronous;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.hibernate.annotations.Type;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.*;

@Log
@Stateless
@Transactional
public class DteGeneratorRepository {

    @PersistenceContext(unitName = "factur")
    private EntityManager em;

    @Inject
    private ConfigurationRepository configurationRepository;

    @Inject
    @TypeElectronicDocument(DocumentType.FISCAL_CREDIT)
    private IDteProcessor dteProcessorFiscalCredit;

    @Inject
    @TypeElectronicDocument(DocumentType.BILL)
    private IDteProcessor dteProcessorBill;

    @Inject
    @TypeElectronicDocument(DocumentType.EXPORT_INVOICE)
    private IDteProcessor dteProcessorExport;

    @Inject
    @TypeElectronicDocument(DocumentType.CREDIT_NOTE)
    private IDteProcessor dteProcessorCreditNote;

    @Inject
    @TypeElectronicDocument(DocumentType.DEBIT_NOTE)
    private IDteProcessor dteProcessorDebitNote;

    @Inject
    @TypeElectronicDocument(DocumentType.DELIVERY_NOTE)
    private IDteProcessor dteProcessorDeliveryNote;

    @Inject
    @TypeElectronicDocument(DocumentType.WITHHOLDING_RECEIPT)
    private IDteProcessor dteProcessorWithholdingReceipt;

    @Inject
    @TypeElectronicDocument(DocumentType.INVALIDATION)
    private IDteProcessor dteProcessorInvalidation;

    @Inject
    private IDtePaymentMapper dtePaymentMapper;

    @Inject
    private IDteBodyMapper dteBodyMapper;

    @Inject
    private DteApiRepository dteApiRepository;

    private List<Setting> settings;

    public Object generate(DteRequestDto request) throws Exception {

        log.info( "request data: " + request.toString());
        var dte = new Object();
        var jsonMapper = new ObjectMapper();
        var data = new Object();
        var dteProcessingResult = new DteApiProcessingResultResponseDte();

        try {

            if (request.getWarehouseOrigin() == null) {
                data = dteSalesBaseData(request);
            } else {
                data = dteInventoryBaseData(request);
            }

            if (request.getDocumentType().equals(2)) {
                dte = dteProcessorFiscalCredit.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            } else if (request.getDocumentType().equals(12) || request.getDocumentType().equals(13)) {
                dte = dteProcessorBill.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            } else if (request.getDocumentType().equals(17)) {
                dte = dteProcessorExport.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            } else if (request.getDocumentType().equals(14)) {
                dte = dteProcessorCreditNote.generate(data , null , dteBodySalesData(request));
            } else if (request.getDocumentType().equals(16)) {
                dte = dteProcessorDebitNote.generate(data , null , dteBodySalesData(request));
            } else if (request.getDocumentType().equals(11)) {
                dte = dteProcessorDeliveryNote.generate(data , null , dteBodyInventoryData(request));
            } else if (request.getDocumentType().equals(20)) {
                dte = dteProcessorWithholdingReceipt.generate(data , null , null);
            } else {
                dte = null;
            }

            if (dte != null) {

                dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte) , RequestProcessType.DTE);

                log.info("receipt stamp value: [" + dteProcessingResult.getReceptionStamp() + "]");

                if (dteProcessingResult.getReceptionStamp() == null || dteProcessingResult.getReceptionStamp().isEmpty()) {
                    registerLog(request , dteProcessingResult);
                } else {
                    stampDocument(request , dteProcessingResult , RequestProcessType.DTE);
                }

            }

            return dteProcessingResult;

        } catch (NullPointerException nullPointerException) {

            nullPointerException.printStackTrace();
            var internalError = DteApiProcessingResultResponseDte.builder().observations(List.of("Datos requeridos incompletos [ " + nullPointerException.getMessage() + " ]")).build();
            registerLog(request , internalError);
            return internalError;

        } catch (Exception exception) {

            exception.printStackTrace();
            var internalError = DteApiProcessingResultResponseDte.builder().observations(List.of("Error interno [ " + exception.getMessage() + " ]")).build();
            registerLog(request , internalError);
            return internalError;

        }

    }

    public Object invalidateDocument(DteRequestDto request) throws Exception {

        log.info( "request data: " + request.toString());

        var mapper = new ObjectMapper();
        var dte = new Object();
        var predicates = new ArrayList<Predicate>();
        var dteProcessingResult = new DteApiProcessingResultResponseDte();

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(ElectronicBillingCancellationsView.class);
        var invalidation = criteria.from(ElectronicBillingCancellationsView.class);
        var client = invalidation.fetch(ElectronicBillingCancellationsView_.client);
        var pointSale = invalidation.fetch(ElectronicBillingCancellationsView_.pointSale);
        var requestBy = invalidation.fetch(ElectronicBillingCancellationsView_.employeeRequestBy , JoinType.LEFT);
        var createdBy = invalidation.fetch(ElectronicBillingCancellationsView_.employeeCreatedBy , JoinType.LEFT);
        var company = invalidation.fetch(ElectronicBillingCancellationsView_.company);

        if (request.getWarehouseOrigin() != null && request.getDocumentType().equals(11)) {
            predicates.add(builder.equal(invalidation.get(ElectronicBillingCancellationsView_.warehouseCode) , request.getWarehouseOrigin()));
        } else {
            predicates.add(builder.equal(invalidation.get(ElectronicBillingCancellationsView_.branchCode) , request.getPosId()));
        }

        criteria.where(builder.equal(invalidation.get(ElectronicBillingCancellationsView_.documentType) , request.getDocumentType()),
                builder.equal(invalidation.get(ElectronicBillingCancellationsView_.documentNumber) , request.getDocumentNumber()),
                builder.equal(builder.function("to_char" , String.class , invalidation.get(ElectronicBillingCancellationsView_.createdThe) , builder.literal("dd/mm/yyyy")) , request.getDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))),
                builder.and(predicates.toArray(new Predicate[0])));

        var result = em.createQuery(criteria).getSingleResult();

        if (result != null) {
            dte = dteProcessorInvalidation.generate(result , null , null);
            dteProcessingResult = dteApiRepository.send(mapper.writeValueAsString(dte) , RequestProcessType.INVALIDATION);

            if (!dteProcessingResult.getReceptionStamp().isBlank()) {
                stampDocument(request , dteProcessingResult , RequestProcessType.INVALIDATION);
            }
        }

//            dteProcessingResult = DteApiProcessingResultResponseDte.builder()
//                .generationCode(result.getGenerationCode())
//                .receptionStamp(UUID.randomUUID().toString())
//                .processingDate(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")).toString())
//                .messageDescription("RECIBIDO")
//                .observations(Collections.emptyList())
//                .build();

        log.info(dteProcessingResult.toString());

        if (!dteProcessingResult.getReceptionStamp().isBlank()) {
                stampDocument(request , dteProcessingResult , RequestProcessType.INVALIDATION);
        }

        return dteProcessingResult;

    }


    private Sales dteSalesBaseData(DteRequestDto request) {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(Sales.class);
        var sale = criteria.from(Sales.class);
        var company = sale.fetch(Sales_.company);
        var companyDepartment = company.fetch(Company_.department);
        var companyMunicipality = company.fetch(Company_.municipality);
        var pointSale = sale.fetch(Sales_.pointSale);
        var pointSaleDepartment = pointSale.fetch(PointSale_.department , JoinType.LEFT);
        var pointSaleMunicipality = pointSale.fetch(PointSale_.municipality , JoinType.LEFT);
        var documentType = sale.fetch(Sales_.documentType , JoinType.LEFT);

        if (!request.getDocumentType().equals(20)) {
            var client = sale.fetch(Sales_.client);
            var clientDepartment = client.fetch(Client_.department , JoinType.LEFT);
            var clientMunicipality = client.fetch(Client_.municipality , JoinType.LEFT);
            var clientCountry = client.fetch(Client_.country , JoinType.LEFT);
            var electronicSummary = sale.fetch(Sales_.electronicBillingSummary  , JoinType.LEFT);
            var seller = sale.fetch(Sales_.seller , JoinType.LEFT);
        } else {
            var supplier = sale.fetch(Sales_.supplier , JoinType.LEFT);
            var supplierCountry = supplier.fetch(Supplier_.country , JoinType.LEFT);
            var supplierDepartment = supplier.fetch(Supplier_.department , JoinType.LEFT);
            var supplierMunicipality = supplier.fetch(Supplier_.municipality , JoinType.LEFT);
            var summary = sale.fetch(Sales_.electronicBillingSummary , JoinType.LEFT);
        }


        criteria.where(builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.pointSaleCode) , request.getPosId()) ,
                builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentTypeCode) , request.getDocumentType()) ,
                builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentNumber) , request.getDocumentNumber()) ,
                builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.companyId) , request.getCompanyId()),
                builder.equal(sale.get(Sales_.documentDate) , request.getDate())
        //        builder.equal(sale.get(Sales_.state) , "G")
        );

        return  em.createQuery(criteria).getSingleResult();

    }


    private List<DtePaymentsDto> dtePaymentData(DteRequestDto request) {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(ElectronicBillingPaymentView.class);
        var payment = criteria.from(ElectronicBillingPaymentView.class);

        criteria.where(builder.equal(payment.get(ElectronicBillingPaymentView_.id).get(ElectronicBillingPaymentViewPrimaryKey_.companyId) , request.getCompanyId())
                        , builder.equal(payment.get(ElectronicBillingPaymentView_.id).get(ElectronicBillingPaymentViewPrimaryKey_.pointSaleCode) , request.getPosId())
                        , builder.equal(payment.get(ElectronicBillingPaymentView_.id).get(ElectronicBillingPaymentViewPrimaryKey_.documentTypeCode), request.getDocumentType())
                        , builder.equal(payment.get(ElectronicBillingPaymentView_.id).get(ElectronicBillingPaymentViewPrimaryKey_.documentNumber) , request.getDocumentNumber())
                        , builder.equal(payment.get(ElectronicBillingPaymentView_.documentDate) , request.getDate()));

        return dtePaymentMapper.toDtePaymentDto(em.createQuery(criteria).getResultList());
    }

    private List<DteDocumentBodyDto> dteBodySalesData(DteRequestDto request) throws Exception {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(ElectronicBillingBodyView.class);
        var body = criteria.from(ElectronicBillingBodyView.class);


        criteria.where(builder.equal(body.get(ElectronicBillingBodyView_.id).get(ElectronicBillingBodyViewPrimaryKey_.companyId) , request.getCompanyId())
                        , builder.equal(body.get(ElectronicBillingBodyView_.id).get(ElectronicBillingBodyViewPrimaryKey_.pointSaleCode) , request.getPosId())
                        , builder.equal(body.get(ElectronicBillingBodyView_.id).get(ElectronicBillingBodyViewPrimaryKey_.documentTypeCode) , request.getDocumentType())
                        , builder.equal(body.get(ElectronicBillingBodyView_.id).get(ElectronicBillingBodyViewPrimaryKey_.documentNumber) , request.getDocumentNumber())
                        , builder.equal(body.get(ElectronicBillingBodyView_.documentDate) , request.getDate()));


        return dteBodyMapper.toDteBodyDto(em.createQuery(criteria).getResultList());

    }

    private List<DteDocumentBodyDto> dteBodyInventoryData(DteRequestDto request) {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(InventoryMovementDetailDto.class);
        var detail = criteria.from(InventoryMovementDetail.class);
        var product = detail.join(InventoryMovementDetail_.product);
        var presentation = detail.join(InventoryMovementDetail_.presentation , JoinType.LEFT);

        criteria.select(builder.construct(InventoryMovementDetailDto.class ,
                detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.productCode),
                detail.get(InventoryMovementDetail_.description),
                builder.coalesce(presentation.get(Presentation_.idPresentationMh) , builder.literal("99")),
                detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.sequence),
                builder.coalesce(product.get(Product_.type) , 1),
                detail.get(InventoryMovementDetail_.quantity),
                detail.get(InventoryMovementDetail_.cost),
                detail.get(InventoryMovementDetail_.total)));
        criteria.where(builder.equal(detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.companyId) , request.getCompanyId()),
                builder.equal(detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.type) , request.getDocumentType()),
                builder.equal(detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.number) , request.getDocumentNumber()),
                builder.equal(detail.get(InventoryMovementDetail_.id).get(InventoryMovementDetailPrimaryKey_.warehouse) , request.getWarehouseOrigin()));

        return dteBodyMapper.toDteBodyDeliveryNoteDto(em.createQuery(criteria).getResultList());
    }
    private InventoryMovementDto dteInventoryBaseData(DteRequestDto request) {

        var builder = em.getCriteriaBuilder();
        var criteria = builder.createQuery(InventoryMovementDto.class);
        var inventoryMovement = criteria.from(InventoryMovement.class);
        var company = inventoryMovement.join(InventoryMovement_.company);
        var pointSale = inventoryMovement.join(InventoryMovement_.pointSale , JoinType.LEFT);
        var pointSaleDepartment = pointSale.join(PointSale_.department , JoinType.LEFT);
        var pointSaleMunicipality = pointSale.join(PointSale_.municipality , JoinType.LEFT);
        var companyDepartment = company.join(Company_.department , JoinType.LEFT);
        var companyMunicipality = company.join(Company_.municipality , JoinType.LEFT);

        criteria.select(builder.construct(InventoryMovementDto.class ,
                inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.type),
                inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.number),
                inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.warehouse),
                inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.companyId),
                inventoryMovement.get(InventoryMovement_.issuedOn),
                inventoryMovement.get(InventoryMovement_.controlNumber),
                inventoryMovement.get(InventoryMovement_.generationCode),
                inventoryMovement.get(InventoryMovement_.taxDocumentVersion),
                inventoryMovement.get(InventoryMovement_.billingModel),
                inventoryMovement.get(InventoryMovement_.transmissionType),
                inventoryMovement.get(InventoryMovement_.contingencyType),
                inventoryMovement.get(InventoryMovement_.contingencyReason),
                inventoryMovement.get(InventoryMovement_.total),
                inventoryMovement.get(InventoryMovement_.subtotal),
                inventoryMovement.get(InventoryMovement_.destinationWarehouse),
                inventoryMovement.get(InventoryMovement_.originAgency),
                inventoryMovement.get(InventoryMovement_.destinationAgency),
                inventoryMovement.get(InventoryMovement_.receivedBy),
                builder.function("fn_transformar_monto_letras" , String.class , inventoryMovement.get(InventoryMovement_.subtotal)),
                builder.function("to_char" , String.class , inventoryMovement.get(InventoryMovement_.issuedOn) , builder.literal("yyyy-mm-dd")),
                builder.function("to_char" , String.class , inventoryMovement.get(InventoryMovement_.issuedOn) , builder.literal("hh24:mi:ss")),
                inventoryMovement.get(InventoryMovement_.impression),
                company,
                pointSale,
                pointSaleDepartment,
                pointSaleMunicipality,
                companyDepartment,
                companyMunicipality
        ));

        criteria.where(builder.equal(inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.type) , request.getDocumentType()),
                        builder.equal(inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.number) , request.getDocumentNumber()),
                        builder.equal(inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.companyId) , request.getCompanyId()),
                        builder.equal(inventoryMovement.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.warehouse) , request.getWarehouseOrigin()),
                        builder.equal(inventoryMovement.get(InventoryMovement_.issuedOn) , request.getDate()));



        return em.createQuery(criteria).getSingleResult();
    }

    private void stampDocument(DteRequestDto request , DteApiProcessingResultResponseDte dteResult , RequestProcessType type) {

        log.info("stamp document");

        var builder = em.getCriteriaBuilder();
        var dteSaleDocuments = new ArrayList<>(List.of(new Integer[] {2, 12, 13 , 17 , 14 , 16 , 20}));
        var dteSaleCancellationDocuments = new ArrayList<>(List.of(new Integer[] {15 , 18 , 19}));
        var dteInventoryDocuments = new ArrayList<>(List.of(new Integer[] {11}));

        if (dteSaleDocuments.contains(request.getDocumentType()) && type.equals(RequestProcessType.DTE)) {

            var criteria = builder.createCriteriaUpdate(Sales.class);
            var sale = criteria.from(Sales.class);

            criteria.set(sale.get(Sales_.electronicReceiptSale) , dteResult.getReceptionStamp())
                    .set(sale.get(Sales_.processedThe) , LocalDateTime.parse(dteResult.getProcessingDate() , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            criteria.where(builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.companyId) , request.getCompanyId()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentTypeCode) , request.getDocumentType()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.pointSaleCode) , request.getPosId()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentNumber) , request.getDocumentNumber()),
                    builder.equal(sale.get(Sales_.documentDate) , request.getDate()),
                    builder.isNull(sale.get(Sales_.electronicReceiptSale)));

            em.createQuery(criteria).executeUpdate();

        } else if ((dteSaleDocuments.contains(request.getDocumentType()) || dteInventoryDocuments.contains(request.getDocumentType())) && type.equals(RequestProcessType.INVALIDATION)) {

            var criteria = builder.createCriteriaUpdate(Cancellations.class);
            var cancellations = criteria.from(Cancellations.class);

            criteria.set(cancellations.get(Cancellations_.receptionStamp) , dteResult.getReceptionStamp())
                    .set(cancellations.get(Cancellations_.generationCode) , dteResult.getGenerationCode())
                    .set(cancellations.get(Cancellations_.processedThe) , LocalDateTime.parse(dteResult.getProcessingDate() , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
            criteria.where(builder.equal(cancellations.get(Cancellations_.pointSale) , request.getPosId()),
                    builder.equal(cancellations.get(Cancellations_.documentType) , request.getDocumentType()),
                    builder.equal(cancellations.get(Cancellations_.documentNumber) , request.getDocumentNumber()),
                    builder.equal(cancellations.get(Cancellations_.createThe) , request.getDate()),
                    builder.equal(cancellations.get(Cancellations_.companyId) , request.getCompanyId()));

            em.createQuery(criteria).executeUpdate();

        } else if (dteSaleCancellationDocuments.contains(request.getDocumentType()) && type.equals(RequestProcessType.INVALIDATION)) {

            var criteria = builder.createCriteriaUpdate(Sales.class);
            var sale = criteria.from(Sales.class);

            criteria.set(sale.get(Sales_.electronicReceiptSale) , dteResult.getReceptionStamp())
                    .set(sale.get(Sales_.generationCode) , dteResult.getGenerationCode())
                    .set(sale.get(Sales_.processedThe) , LocalDateTime.parse(dteResult.getProcessingDate() , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            criteria.where(builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.companyId) , request.getCompanyId()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentTypeCode) , request.getDocumentType()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.pointSaleCode) , request.getPosId()),
                    builder.equal(sale.get(Sales_.id).get(SalesPrimaryKey_.documentNumber) , request.getDocumentNumber()),
                    builder.equal(sale.get(Sales_.documentDate) , request.getDate()),
                    builder.isNull(sale.get(Sales_.electronicReceiptSale)));

            em.createQuery(criteria).executeUpdate();

        } else {

            var criteria = builder.createCriteriaUpdate(InventoryMovement.class);
            var inventory = criteria.from(InventoryMovement.class);

            criteria.set(inventory.get(InventoryMovement_.electronicReceiptSale) , dteResult.getReceptionStamp())
                    .set(inventory.get(InventoryMovement_.processingThe) , LocalDateTime.parse(dteResult.getProcessingDate() , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));

            criteria.where(builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.companyId) , request.getCompanyId()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.number) , request.getDocumentNumber()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.warehouse), request.getWarehouseOrigin()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.type) , request.getDocumentType()),
                    builder.isNull(inventory.get(InventoryMovement_.electronicReceiptSale)));

            em.createQuery(criteria).executeUpdate();

        }


    }

    private void registerLog(DteRequestDto request , DteApiProcessingResultResponseDte apiResult) {

        var register = DteTransmissionLog.builder()
                                        .companyId(request.getCompanyId())
                                        .documentType(request.getDocumentType())
                                        .branchCode(request.getPosId())
                                        .warehouseCode(request.getWarehouseOrigin())
                                        .documentNumber(request.getDocumentNumber())
                                        .documentIssueDate(request.getDate())
                                        .observationsMh(apiResult.getObservations().toString().concat(" - ").concat(apiResult.getMessageDescription()))
                                        .descriptionConditionMh(apiResult.getMessageDescription())
                                        .processedThe(apiResult.getProcessingDate() != null ? LocalDateTime.parse(apiResult.getProcessingDate() , DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) : LocalDateTime.now())
                                        .createdThe(LocalDateTime.now())
                                        .build();

        em.persist(register);

    }

    public DteGeneratorRepository() {
    }
}
