package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@AllArgsConstructor
@SuperBuilder
public class DteIdentificationDto {

    @JsonProperty(value = "version")
    private Integer version;

    @JsonProperty(value = "ambiente")
    private String destinationEnvironment;

    @JsonProperty("codigoGeneracion")
    private String generationCode;

}
