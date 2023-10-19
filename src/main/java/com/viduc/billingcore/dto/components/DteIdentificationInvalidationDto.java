package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteIdentificationInvalidationDto extends DteIdentificationDto{

    @JsonProperty("fecAnula")
    private String dateIssuedOn;

    @JsonProperty("horAnula")
    private String hourIssuedOn;

}
