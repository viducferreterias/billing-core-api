package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteTransmitterDto {

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("nrc")
    private String nrc;

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("codActividad")
    private String activityCode;

    @JsonProperty("descActividad")
    private String activityDescription;

    @JsonProperty("nombreComercial")
    private String commercialName;

    @JsonProperty("tipoEstablecimiento")
    private String establishmentType;

    @JsonProperty("direccion")
    private DteAddressDto address;

    @JsonProperty("telefono")
    private String phone;

    @JsonProperty("correo")
    private String email;

    @JsonProperty("codEstableMH")
    private String establishmentCodeMh;

    @JsonProperty("codEstable")
    private String establishmentCode;

    @JsonProperty("codPuntoVentaMH")
    private String pointSaleCodeMh;

    @JsonProperty("codPuntoVenta")
    private String pointSaleCode;

}
