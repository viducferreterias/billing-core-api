package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteReceiverInvoiceSaleDto extends DteReceiverSaleDocumentDto {

    @JsonProperty("tipoDocumento")
    private String typeIdentificationDocument;

    @JsonProperty("numDocumento")
    private String numberIdentificationDocument;

    @JsonProperty("nrc")
    private String nrc;

    @JsonProperty("codActividad")
    private String activityCode;

    @JsonProperty("descActividad")
    private String activityDescription;

    @JsonProperty("direccion")
    private DteAddressDto address;

}
