package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteReceiverDeliveryNoteDto extends DteReceiverSaleDocumentDto{

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

    @JsonProperty("bienTitulo")
    private String referralType;

}
