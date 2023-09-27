package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteDocumentBodyTaxReceiptDto extends DteDocumentBodyDto{

    @JsonProperty("tipoItem")
    private Integer itemType;

    @JsonProperty("numeroDocumento")
    private String documentNumber;

    @JsonProperty("codTributo")
    private String tributeCode;

    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("ventaNoSuj")
    private Float saleNotSubject;

    @JsonProperty("ventaExenta")
    private Float exemptSale;

    @JsonProperty("noGravado")
    private Float notTaxed;

    @JsonProperty("psv")
    private Float suggestedRetailPrice;

}
