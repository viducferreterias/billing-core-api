package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class DteSchemaWithholdingReceiptResponseDto {

    @JsonProperty(value = "identificacion")
    private DteIdentificationDto identification;

    @JsonProperty(value = "emisor")
    private DteTransmitterDto transmitter;

    @JsonProperty(value = "receptor")
    private DteReceiverSaleDocumentDto receiver;

    @JsonProperty(value = "cuerpoDocumento")
    private List<DteDocumentBodyWithholdingReceiptDto> body;

    @JsonProperty(value = "resumen")
    private DteSummaryWithholdingReceiptResponseDto summary;

    @JsonProperty(value = "extension")
    private DteExtensionDto extension;

    @JsonProperty(value = "apendice")
    private List<DteAppendixDto> appendix;


}
