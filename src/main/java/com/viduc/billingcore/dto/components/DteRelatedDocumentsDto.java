package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteRelatedDocumentsDto {

    @JsonProperty(value = "tipoDocumento")
    private String type;

    @JsonProperty(value = "tipoGeneracion")
    private Integer generationType;

    @JsonProperty(value = "numeroDocumento")
    private String number;

    @JsonProperty(value = "fechaEmision")
    private String date;

}
