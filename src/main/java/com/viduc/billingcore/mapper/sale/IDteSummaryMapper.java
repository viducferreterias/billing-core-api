package com.viduc.billingcore.mapper.sale;

import com.viduc.billingcore.domain.Sales;
import com.viduc.billingcore.dto.components.*;
import com.viduc.billingcore.repository.sale.DteGeneratorRepository;
import jakarta.inject.Inject;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.*;
import java.util.stream.Collectors;

@Mapper
public interface IDteSummaryMapper {

    IDteSummaryMapper INSTANCE = Mappers.getMapper(IDteSummaryMapper.class);

    @Mappings({
            @Mapping(target = "totalInWords" , source = "data.electronicBillingSummary.totalWords"),
            @Mapping(target = "totalNotSubject" , constant = "0.0F"),
            @Mapping(target = "totalExempt" , source = "data.electronicBillingSummary.fullyExempt"),
            @Mapping(target = "totalTaxed" , source = "data.electronicBillingSummary.totalTaxed"),
            @Mapping(target = "subtotalSale" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "discountNotSubject" , constant = "0.0F"),
            @Mapping(target = "discountExempt" , constant = "0.0F"),
            @Mapping(target = "discountTaxed" , constant = "0.0F"),
            @Mapping(target = "percentageDiscount" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "subtotal" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "perceptionTax" , source = "data.electronicBillingSummary.perception"),
            @Mapping(target = "retentionTax" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "incomeWithholding" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "totalAmountOperation" , source = "data.electronicBillingSummary.fullOperation"),
            @Mapping(target = "totalNotTaxed" , constant = "0.0F"),
            @Mapping(target = "totalToPay" , source = "data.electronicBillingSummary.totalPayment"),
            @Mapping(target = "positiveBalance" , constant = "0.0F"),
            @Mapping(target = "operatingCondition" , source = "data.electronicBillingSummary.operatingCondition"),
            @Mapping(target = "tributes" , expression = "java(setTribute(data.getElectronicBillingSummary().getIva()))"),
            @Mapping(target = "payments" , source = "paymentData")
    })
    DteSummaryTaxReceiptSaleDto toDteSummaryTaxReceiptDto(Sales data , List<DtePaymentsDto> paymentData);

    @Mappings({
            @Mapping(target = "totalSubjectWithholding" , source = "data.subtotal"),
            @Mapping(target = "totalTaxWithheld" , source = "data.perception"),
            @Mapping(target = "totalTaxWithheldLetters" , source = "data.electronicBillingSummary.totalWords"),
    })
    DteSummaryWithholdingReceiptResponseDto toDteSummaryWithholdingReceiptDto(Sales data);

    @Mappings({
            @Mapping(target = "totalInWords" , source = "data.electronicBillingSummary.totalWords"),
            @Mapping(target = "totalNotSubject" , constant = "0.0F"),
            @Mapping(target = "totalExempt" , source = "data.electronicBillingSummary.fullyExempt"),
            @Mapping(target = "totalTaxed" , source = "data.electronicBillingSummary.totalTaxed"),
            @Mapping(target = "subtotalSale" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "discountNotSubject" , constant = "0.0F"),
            @Mapping(target = "discountExempt" , constant = "0.0F"),
            @Mapping(target = "discountTaxed" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "subtotal" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "perceptionTax" , source = "data.electronicBillingSummary.perception"),
            @Mapping(target = "retentionTax" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "totalAmountOperation" , source = "data.electronicBillingSummary.fullOperation"),
            @Mapping(target = "operatingCondition" , source = "data.electronicBillingSummary.operatingCondition"),
            @Mapping(target = "incomeWithholding" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "tributes" , expression = "java(setTribute(data.getElectronicBillingSummary().getIva()))"),
    })
    DteSummaryCreditNoteDto toDteSummaryCreditNoteDto(Sales data);

    @Mappings({
            @Mapping(target = "totalInWords" , source = "data.electronicBillingSummary.totalWords"),
            @Mapping(target = "totalNotSubject" , constant = "0.0F"),
            @Mapping(target = "totalExempt" , source = "data.electronicBillingSummary.fullyExempt"),
            @Mapping(target = "totalTaxed" , source = "data.electronicBillingSummary.totalTaxed"),
            @Mapping(target = "subtotalSale" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "discountNotSubject" , constant = "0.0F"),
            @Mapping(target = "discountExempt" , constant = "0.0F"),
            @Mapping(target = "discountTaxed" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "subtotal" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "perceptionTax" , source = "data.electronicBillingSummary.perception"),
            @Mapping(target = "retentionTax" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "totalAmountOperation" , source = "data.electronicBillingSummary.fullOperation"),
            @Mapping(target = "operatingCondition" , source = "data.electronicBillingSummary.operatingCondition"),
            @Mapping(target = "incomeWithholding" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "tributes" , expression = "java(setTribute(data.getElectronicBillingSummary().getIva()))"),
            @Mapping(target = "positiveBalance" , constant = "0.0F"),
    })
    DteSummaryDebitNoteDto toDteSummaryDebitNoteDto(Sales data);


    @Mappings({
            @Mapping(target = "totalInWords" , source = "data.electronicBillingSummary.totalWords"),
            @Mapping(target = "totalNotSubject" , constant = "0.0F"),
            @Mapping(target = "totalExempt" , source = "data.electronicBillingSummary.fullyExempt"),
            @Mapping(target = "totalTaxed" , source = "data.electronicBillingSummary.totalTaxed"),
            @Mapping(target = "subtotalSale" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "discountNotSubject" , constant = "0.0F"),
            @Mapping(target = "discountExempt" , constant = "0.0F"),
            @Mapping(target = "discountTaxed" , constant = "0.0F"),
            @Mapping(target = "percentageDiscount" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "subtotal" , source = "data.electronicBillingSummary.subtotal"),
            @Mapping(target = "perceptionTax" , source = "data.electronicBillingSummary.perception"),
            @Mapping(target = "retentionTax" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "incomeWithholding" , source = "data.electronicBillingSummary.retention"),
            @Mapping(target = "totalAmountOperation" , source = "data.electronicBillingSummary.fullOperation"),
            @Mapping(target = "totalNotTaxed" , constant = "0.0F"),
            @Mapping(target = "totalToPay" , source = "data.electronicBillingSummary.totalPayment"),
            @Mapping(target = "positiveBalance" , constant = "0.0F"),
            @Mapping(target = "operatingCondition" , source = "data.electronicBillingSummary.operatingCondition"),
            @Mapping(target = "tributes" , ignore = true),
            @Mapping(target = "fullTax" , source = "data.electronicBillingSummary.iva"),
            @Mapping(target = "payments" , source = "paymentData")
    })
    DteSummaryInvoiceDto toDteSummaryBillDocumentDto(Sales data , List<DtePaymentsDto> paymentData);


    @Mappings({
            @Mapping(target = "totalNotSubject" , constant = "0.0F"),
            @Mapping(target = "totalExempt" , constant = "0.0F"),
            @Mapping(target = "totalTaxed" , source = "data.total"),
            @Mapping(target = "subtotalSale" , source = "data.subtotal"),
            @Mapping(target = "discountNotSubject" , constant = "0.0F"),
            @Mapping(target = "discountExempt" , constant = "0.0F"),
            @Mapping(target = "discountTaxed" , constant = "0.0F"),
            @Mapping(target = "percentageDiscount" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "subtotal" , source = "data.subtotal"),
            @Mapping(target = "totalAmountOperation" , source = "data.total"),
            @Mapping(target = "totalInWords" , source = "data.valueInWord"),
    })
    DteSummaryDeliveryNoteDto toDteSummaryDeliveryNoteDto(InventoryMovementDto data);

    @Mappings({
            @Mapping(target = "totalInWords" , source = "data.electronicBillingSummary.totalWords"),
            @Mapping(target = "totalTaxed" , source = "data.electronicBillingSummary.totalTaxed"),
            @Mapping(target = "discount" , constant = "0.0F"),
            @Mapping(target = "percentageDiscount" , constant = "0.0F"),
            @Mapping(target = "totalDiscount" , constant = "0.0F"),
            @Mapping(target = "sure" , constant = "0.0F"),
            @Mapping(target = "freight" , constant = "0.0F"),
            @Mapping(target = "totalAmountOperation" , source = "data.electronicBillingSummary.fullOperation"),
            @Mapping(target = "totalNotTaxed" , constant = "0.0F"),
            @Mapping(target = "totalToPay" , source = "data.electronicBillingSummary.totalPayment"),
            @Mapping(target = "operatingCondition" , source = "data.electronicBillingSummary.operatingCondition"),
            @Mapping(target = "payments" , source = "paymentData"),
            @Mapping(target = "incotermsCode" , source = "data.electronicBillingSummary.incotermsCode"),
            @Mapping(target = "incotermsDescription" , source = "data.electronicBillingSummary.descriptionIncotermsCode"),
            @Mapping(target = "comments" , ignore = true)
    })
    DteSummaryExportSaleDocumentDto toDteSummaryExportSaleDocumentDto(Sales data , List<DtePaymentsDto> paymentData);
    default List<DteTributesDto> setTribute(Float amount) {

        var tributesDetail = new ArrayList<DteTributesDto>();

        if (amount > 0.0F) {
            tributesDetail.add(DteTributesDto.builder().description("Impuesto al Valor Agregado 13%").code("20").value(amount).build());
        }

        return tributesDetail;

    }

}
