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

    @JsonProperty("tipoDte")
    private String dteType;

    @JsonProperty("numeroControl")
    private String controlNumber;

    @JsonProperty("codigoGeneracion")
    private String generationCode;

    @JsonProperty(value = "tipoModelo")
    private Integer billingModel;

    @JsonProperty(value = "tipoOperacion")
    private Integer transmissionType;

    @JsonProperty(value = "tipoContingencia")
    private Integer contingencyType;

    @JsonProperty(value = "motivoContin")
    private String contingencyReason;

    @JsonProperty("fecEmi")
    private String dateIssuedOn;

    @JsonProperty("horEmi")
    private String hourIssuedOn;

    @JsonProperty("tipoMoneda")
    private String coinType;

}
