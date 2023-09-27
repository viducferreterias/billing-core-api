package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteDocumentBodyInvoiceDto extends DteDocumentBodyDto{

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

    @JsonProperty("psv")
    private Float suggestedRetailPrice;

    @JsonProperty("ivaItem")
    private Float itemTax;

    @JsonProperty("noGravado")
    private Float notTaxed;

}
