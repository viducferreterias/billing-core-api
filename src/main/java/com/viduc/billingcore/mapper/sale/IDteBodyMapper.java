package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.domain.view.ElectronicBillingBodyView;
import com.viduc.billingcore.dto.components.*;
import jakarta.annotation.Nullable;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "cdi")
public interface IDteBodyMapper {

    IDteBodyMapper INSTANCE = Mappers.getMapper(IDteBodyMapper.class);

    //@Mapping(target = "itemNumber" , ignore = true)
    List<DteDocumentBodyDto> toDteBodyDto(List<ElectronicBillingBodyView> data);

    List<DteDocumentBodyDto> toDteBodyDeliveryNoteDto(List<InventoryMovementDetailDto> date);

    @Mappings({
            @Mapping(target = "itemNumber" , constant = "1"),
            @Mapping(target = "electronicDocumentType" , constant = "03"),
            @Mapping(target = "documentNumber" , source = "data.relatedInvoiceNumber"),
            @Mapping(target = "documentType" , expression = "java(getDocumentType(data.getRelatedInvoiceNumber()))" , nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS),
            @Mapping(target = "issuedOn" , source = "data.referenceDate"),
            @Mapping(target = "taxableAmount" , source = "data.subtotal"),
            @Mapping(target = "mhRetentionCode" , constant = "22"),
            @Mapping(target = "withheldTax" , source = "data.perception"),
            @Mapping(target = "description" , source = "data.comment3")
    })
    DteDocumentBodyWithholdingReceiptDto toDteBodyWithholdingReceiptDto(Sales data);

    default Integer getDocumentType(String documentNumber) {

        if (documentNumber.length() >= 36) {
            return 2;
        } else {
            return 1;
        }
    }

    default DteDocumentBodyDto toDteBodyDeliveryNoteDto(InventoryMovementDetailDto data) {
        return DteDocumentBodyDeliveryNoteDto.builder()
                .itemNumber(data.getSequence())
                .itemType(data.getProductType())
                .quantity(data.getQuantity())
                .code(data.getProductCode())
                .unitMeasure(Integer.parseInt(data.getIdPresentationMh()))
                .description(data.getProductDescription())
                .price(data.getCost())
                .discount(0.0F)
                .saleNotSubject(0.0F)
                .exemptSale(0.0F)
                .taxedSale(data.getTotal())
                .notTaxed(0.0F)
                .build();
    }

    default DteDocumentBodyDto toDteBodyDto(ElectronicBillingBodyView data) {

        var tributes = new ArrayList<String>();

        if (data.getTaxType().equals(1)) {
          tributes.add("20");
        }


        if (data.getId().getDocumentTypeCode().equals(2)) {
            return DteDocumentBodyTaxReceiptDto.builder()
                    .itemNumber(data.getId().getSequence())
                    .itemType(data.getProductType())
                    .code(data.getProductCode())
                    .quantity(data.getUnits())
                    .unitMeasure(data.getMeasurementUnit())
                    .description(data.getProductDescription())
                    .price(data.getUnitPrice())
                    .discount(0.0F)
                    .saleNotSubject(0.0F)
                    .notTaxed(0.0F)
                    .suggestedRetailPrice(0.0F)
                    .tributes(tributes)
                    .saleNotSubject(0.0F)
                    .taxedSale(data.getTaxedSale())
                    .exemptSale(data.getUntaxedSale())
                    .notTaxed(0.0F)
                    .build();
        } else if (data.getId().getDocumentTypeCode().equals(12) || data.getId().getDocumentTypeCode().equals(13)) {
            return DteDocumentBodyInvoiceDto.builder()
                    .itemNumber(data.getId().getSequence())
                    .itemType(data.getProductType())
                    .code(data.getProductCode())
                    .quantity(data.getUnits())
                    .unitMeasure(data.getMeasurementUnit())
                    .description(data.getProductDescription())
                    .price(data.getUnitPrice())
                    .discount(0.0F)
                    .saleNotSubject(0.0F)
                    .notTaxed(0.0F)
                    .suggestedRetailPrice(0.0F)
                    .saleNotSubject(0.0F)
                    .taxedSale(data.getTaxedSale())
                    .exemptSale(data.getUntaxedSale())
                    .notTaxed(0.0F)
                    .itemTax(data.getIva())
                    .build();
        } else if (data.getId().getDocumentTypeCode().equals(17)) {
            return DteDocumentBodyExportSaleDto.builder()
                    .itemNumber(data.getId().getSequence())
                    .code(data.getProductCode())
                    .quantity(data.getUnits())
                    .unitMeasure(data.getMeasurementUnit())
                    .description(data.getProductDescription())
                    .price(data.getUnitPrice())
                    .discount(0.0F)
                    .notTaxed(0.0F)
                    .taxedSale(data.getTaxedSale())
                    .notTaxed(0.0F)
                    .build();
        } else if (data.getId().getDocumentTypeCode().equals(14)) {
            return DteDocumentBodyCreditNoteDto.builder()
                    .itemNumber(data.getId().getSequence())
                    .itemType(data.getProductType())
                    .documentNumber(data.getRelatedDocumentNumber())
                    .quantity(data.getUnits())
                    .code(data.getProductCode())
                    .unitMeasure(data.getMeasurementUnit())
                    .description(data.getProductDescription())
                    .price(data.getUnitPrice())
                    .discount(0.0F)
                    .saleNotSubject(0.0F)
                    .exemptSale(0.0F)
                    .taxedSale(data.getTaxedSale())
                    .tributes(tributes)
                    .build();
        } else if (data.getId().getDocumentTypeCode().equals(16)) {
            return DteDocumentBodyDebitNoteDto.builder()
                    .itemNumber(data.getId().getSequence())
                    .itemType(data.getProductType())
                    .documentNumber(data.getRelatedDocumentNumber())
                    .quantity(data.getUnits())
                    .code(data.getProductCode())
                    .unitMeasure(data.getMeasurementUnit())
                    .description(data.getProductDescription())
                    .price(data.getUnitPrice())
                    .discount(0.0F)
                    .saleNotSubject(0.0F)
                    .exemptSale(0.0F)
                    .taxedSale(data.getTaxedSale())
                    .tributes(tributes)
                    .suggestedRetailPrice(0.0F)
                    .notTaxed(0.0F)
                    .build();
        }else {
            return DteDocumentBodyDto.builder().build();
        }



    }

}
