package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.DteIdentificationDto;
import com.viduc.billingcore.dto.components.DteReasonDto;
import com.viduc.billingcore.dto.components.DteReceiverSaleDocumentDto;
import com.viduc.billingcore.dto.components.DteTransmitterInvalidationDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteSchemaInvalidationResponseDto {

    @JsonProperty(value = "identificacion")
    private DteIdentificationDto identification;

    @JsonProperty(value = "emisor")
    private DteTransmitterInvalidationDto transmitter;

    @JsonProperty(value = "documento")
    private DteReceiverSaleDocumentDto document;

    @JsonProperty(value = "motivo")
    private DteReasonDto reason;

}
