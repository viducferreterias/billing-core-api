package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteDocumentBodyExportSaleDto extends DteDocumentBodyDto{

    @JsonProperty(value = "descripcion")
    private String description;

    @JsonProperty("noGravado")
    private Float notTaxed;

}
