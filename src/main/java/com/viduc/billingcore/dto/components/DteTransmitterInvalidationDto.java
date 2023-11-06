package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteTransmitterInvalidationDto {

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("nomEstablecimiento")
    private String establishmentName;

    @JsonProperty("tipoEstablecimiento")
    private String establishmentType;

    @JsonProperty("codEstableMH")
    private String establishmentCodeMh;

    @JsonProperty("codEstable")
    private String establishmentCode;

    @JsonProperty("codPuntoVentaMH")
    private String pointSaleCodeMh;

    @JsonProperty("codPuntoVenta")
    private String pointSaleCode;

    @JsonProperty("telefono")
    private String phone;

    @JsonProperty("correo")
    private String email;

}
