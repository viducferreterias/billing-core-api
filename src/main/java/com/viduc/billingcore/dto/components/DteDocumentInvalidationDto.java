package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteDocumentInvalidationDto  extends DteReceiverSaleDocumentDto{

    @JsonProperty(value = "tipoDte")
    private String dteType;

    @JsonProperty(value = "codigoGeneracion")
    private String generationCode;

    @JsonProperty(value = "selloRecibido")
    private String receptionStamp;

    @JsonProperty(value = "numeroControl")
    private String controlNumber;

    @JsonProperty(value = "fecEmi")
    private String dateIssuedOn;

    @JsonProperty(value = "montoIva")
    private Float taxAmount;

    @JsonProperty(value = "codigoGeneracionR")
    private String relatedGenerationCode;

    @JsonProperty("tipoDocumento")
    private String typeIdentificationDocument;

    @JsonProperty("numDocumento")
    private String numberIdentificationDocument;

}
