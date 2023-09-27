package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteTributesDto {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("descripcion")
    private String description;

    @JsonProperty("valor")
    private Float value;

}
