package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteAppendixDto {

    @JsonProperty("campo")
    private String field;

    @JsonProperty("etiqueta")
    private String label;

    @JsonProperty("valor")
    private String value;

}
