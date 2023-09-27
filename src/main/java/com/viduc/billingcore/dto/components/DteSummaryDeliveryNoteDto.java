package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteSummaryDeliveryNoteDto extends DteSummarySaleDocumentDto{

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

    @JsonProperty("porcentajeDescuento")
    private Float percentageDiscount;

    @JsonProperty("totalDescu")
    private Float totalDiscount;

    @JsonProperty("tributos")
    private List<DteTributesDto> tributes;

    @JsonProperty("subTotal")
    private Float subtotal;

    @JsonProperty("montoTotalOperacion")
    private Float totalAmountOperation;

}
