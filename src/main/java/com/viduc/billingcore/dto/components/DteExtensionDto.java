package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteExtensionDto {

    @JsonProperty(value = "nombEntrega")
    private String deliveryName;

    @JsonProperty(value = "docuEntrega")
    private String deliveryDocument;

    @JsonProperty(value = "nombRecibe")
    private String nameReceives;

    @JsonProperty(value = "docuRecibe")
    private String documentReceives;

    @JsonProperty(value = "observaciones")
    private String observations;

    @JsonProperty(value = "placaVehiculo")
    private String vehiclePlate;

}
