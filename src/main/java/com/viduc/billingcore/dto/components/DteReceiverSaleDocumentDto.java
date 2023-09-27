package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@EqualsAndHashCode
@SuperBuilder
public class DteReceiverSaleDocumentDto {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("telefono")
    private String phoneNumber;

    @JsonProperty("correo")
    private String email;

}
