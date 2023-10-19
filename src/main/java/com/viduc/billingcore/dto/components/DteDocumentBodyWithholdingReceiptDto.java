package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteDocumentBodyWithholdingReceiptDto {

    @JsonProperty("numItem")
    private Integer itemNumber;

    @JsonProperty("tipoDte")
    private String electronicDocumentType;

    @JsonProperty("tipoDoc")
    private Integer documentType;

    @JsonProperty("numDocumento")
    private String documentNumber;

    @JsonProperty("fechaEmision")
    private String issuedOn;

    @JsonProperty("montoSujetoGrav")
    private Float taxableAmount;

    @JsonProperty("codigoRetencionMH")
    private String mhRetentionCode;

    @JsonProperty("ivaRetenido")
    private Float withheldTax;

    @JsonProperty("descripcion")
    private String description;

}
