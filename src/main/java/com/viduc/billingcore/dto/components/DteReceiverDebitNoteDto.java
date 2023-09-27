package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteReceiverDebitNoteDto extends DteReceiverSaleDocumentDto{

    @JsonProperty("nit")
    private String nit;

    @JsonProperty("nrc")
    private String nrc;

    @JsonProperty("codActividad")
    private String activityCode;

    @JsonProperty("descActividad")
    private String activityDescription;

    @JsonProperty("nombreComercial")
    private String commercialName;

    @JsonProperty("direccion")
    private DteAddressDto address;

}
