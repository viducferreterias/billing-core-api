package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteAddressDto {

    @JsonProperty("departamento")
    private String departmentCode;

    @JsonProperty("municipio")
    private String municipality;

    @JsonProperty("complemento")
    private String complement;

}
