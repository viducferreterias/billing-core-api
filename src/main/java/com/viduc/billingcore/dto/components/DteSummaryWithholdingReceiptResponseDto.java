package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteSummaryWithholdingReceiptResponseDto {

    @JsonProperty(value = "totalSujetoRetencion")
    public Float totalSubjectWithholding;

    @JsonProperty(value = "totalIVAretenido")
    public Float totalTaxWithheld;

    @JsonProperty(value = "totalIVAretenidoLetras")
    public String totalTaxWithheldLetters;

}
