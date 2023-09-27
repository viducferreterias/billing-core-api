package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class DteSummaryExportSaleDocumentDto extends DteSummarySaleDocumentDto{

    @JsonProperty("totalGravada")
    private Float totalTaxed;

    @JsonProperty(value = "descuento")
    private Float discount;

    @JsonProperty("porcentajeDescuento")
    private Float percentageDiscount;

    @JsonProperty("totalDescu")
    private Float totalDiscount;

    @JsonProperty(value = "seguro")
    private Float sure;

    @JsonProperty(value = "flete")
    private Float freight;

    @JsonProperty("montoTotalOperacion")
    private Float totalAmountOperation;

    @JsonProperty("totalNoGravado")
    private Float totalNotTaxed;

    @JsonProperty("totalPagar")
    private Float totalToPay;

    @JsonProperty("condicionOperacion")
    private Integer operatingCondition;

    @JsonProperty("pagos")
    private List<DtePaymentsDto> payments;

    @JsonProperty(value = "codIncoterms")
    private String incotermsCode;

    @JsonProperty(value = "descIncoterms")
    private String incotermsDescription;

    @JsonProperty("numPagoElectronico")
    private String electronicPaymentNumber;

    @JsonProperty(value = "observaciones")
    private String comments;


}
