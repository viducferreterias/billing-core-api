package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteSummaryCreditNoteDto extends DteSummarySaleDocumentDto{

    @JsonProperty("totalNoSuj")
    private Float totalNotSubject;

    @JsonProperty("totalExenta")
    private Float totalExempt;

    @JsonProperty("totalGravada")
    private Float totalTaxed;

    @JsonProperty("subTotalVentas")
    private Float subtotalSale;

    @JsonProperty("descuNoSuj")
    private Float discountNotSubject;

    @JsonProperty("descuExenta")
    private Float discountExempt;

    @JsonProperty("descuGravada")
    private Float discountTaxed;

    @JsonProperty("totalDescu")
    private Float totalDiscount;

    @JsonProperty("tributos")
    private List<DteTributesDto> tributes;

    @JsonProperty("subTotal")
    private Float subtotal;

    @JsonProperty("ivaPerci1")
    private Float perceptionTax;

    @JsonProperty("ivaRete1")
    private Float retentionTax;

    @JsonProperty("reteRenta")
    private Float incomeWithholding;

    @JsonProperty("montoTotalOperacion")
    private Float totalAmountOperation;

    @JsonProperty("condicionOperacion")
    private Integer operatingCondition;

}
