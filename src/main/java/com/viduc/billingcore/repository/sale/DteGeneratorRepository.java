package com.viduc.billingcore.repository.sale;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viduc.billingcore.domain.*;
import com.viduc.billingcore.domain.view.*;
import com.viduc.billingcore.dto.components.DteDocumentBodyDto;
import com.viduc.billingcore.dto.components.DtePaymentsDto;
import com.viduc.billingcore.dto.components.InventoryMovementDetailDto;
import com.viduc.billingcore.dto.components.InventoryMovementDto;
import com.viduc.billingcore.dto.request.sales.DteRequestDto;
import com.viduc.billingcore.dto.response.DteApiProcessingResultResponseDte;
import com.viduc.billingcore.mapper.sale.IDteBodyMapper;
import com.viduc.billingcore.mapper.sale.IDtePaymentMapper;
import com.viduc.billingcore.repository.configuration.ConfigurationRepository;
import com.viduc.billingcore.repository.configuration.DteApiRepository;
import com.viduc.billingcore.utils.enums.DocumentType;
import com.viduc.billingcore.utils.qualifier.TypeElectronicDocument;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.JoinType;
import jakarta.transaction.Transactional;
import lombok.extern.java.Log;
import org.hibernate.annotations.Type;

import java.util.Collections;
import java.util.List;

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

        if (request.getWarehouseOrigin() == null) {
            data = dteSalesBaseData(request);
        } else {
            data = dteInventoryBaseData(request);
        }

        if (request.getDocumentType().equals(2)) {
            dte = dteProcessorFiscalCredit.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(12) || request.getDocumentType().equals(13)) {
            dte = dteProcessorBill.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(17)) {
            dte = dteProcessorExport.generate(data , dtePaymentData(request) , dteBodySalesData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(14)) {
            dte = dteProcessorCreditNote.generate(data , null , dteBodySalesData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(16)) {
            dte = dteProcessorDebitNote.generate(data , null , dteBodySalesData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(11)) {
            dte = dteProcessorDeliveryNote.generate(data , null , dteBodyInventoryData(request));
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else if (request.getDocumentType().equals(20)) {
            dte = dteProcessorWithholdingReceipt.generate(data , null , null);
            dteProcessingResult = dteApiRepository.send(jsonMapper.writeValueAsString(dte));
        } else {
            dte = null;
        }

        if (!dteProcessingResult.getReceptionStamp().isBlank()) {
            stampDocument(request , dteProcessingResult);
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

        if (!request.getDocumentType().equals(20)) {
            var client = sale.fetch(Sales_.client);
            var clientDepartment = client.fetch(Client_.department , JoinType.LEFT);
            var clientMunicipality = client.fetch(Client_.municipality , JoinType.LEFT);
            var clientCountry = client.fetch(Client_.country , JoinType.LEFT);
            var electronicSummary = sale.fetch(Sales_.electronicBillingSummary  , JoinType.LEFT);
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
                builder.equal(sale.get(Sales_.documentDate) , request.getDate()),
                builder.equal(sale.get(Sales_.state) , "G"));

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


        var result = em.createQuery(criteria).getResultList();

        return dteBodyMapper.toDteBodyDto(result);

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

    private void stampDocument(DteRequestDto request , DteApiProcessingResultResponseDte dteResult) {

        var builder = em.getCriteriaBuilder();

        if (request.getDocumentType().equals(2) || request.getDocumentType().equals(12) || request.getDocumentType().equals(13) || request.getDocumentType().equals(17) || request.getDocumentType().equals(14) || request.getDocumentType().equals(16) || request.getDocumentType().equals(20)) {

            var criteria = builder.createCriteriaUpdate(Sales.class);
            var sale = criteria.from(Sales.class);

            criteria.set(sale.get(Sales_.electronicReceiptSale) , dteResult.getReceptionStamp());
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

            criteria.set(inventory.get(InventoryMovement_.electronicReceiptSale) , dteResult.getReceptionStamp());
            criteria.where(builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.companyId) , request.getCompanyId()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.number) , request.getDocumentNumber()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.warehouse), request.getWarehouseOrigin()),
                    builder.equal(inventory.get(InventoryMovement_.id).get(InventoryMovementPrimaryKey_.type) , request.getDocumentType()),
                    builder.isNull(inventory.get(InventoryMovement_.electronicReceiptSale)));

            em.createQuery(criteria).executeUpdate();

        }


    }

    public DteGeneratorRepository() {
    }
}
