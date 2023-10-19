package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteIdentificationBaseDocumentDto extends DteIdentificationDto{

    @JsonProperty("tipoDte")
    private String dteType;

    @JsonProperty("numeroControl")
    private String controlNumber;

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
