package com.viduc.billingcore.dto.components;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteReceiverExportInvoiceSaleDto extends DteReceiverSaleDocumentDto {

    @JsonProperty("tipoDocumento")
    private String typeIdentificationDocument;

    @JsonProperty("numDocumento")
    private String numberIdentificationDocument;

    @JsonProperty("nombreComercial")
    private String commercialName;

    @JsonProperty("codPais")
    private String countryCode;

    @JsonProperty("nombrePais")
    private String countryName;

    @JsonProperty("complemento")
    private String complement;

    @JsonProperty("tipoPersona")
    private Integer personType;

    @JsonProperty("descActividad")
    private String activityDescription;

}
