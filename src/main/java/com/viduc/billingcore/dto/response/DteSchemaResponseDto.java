package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.*;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@SuperBuilder
public class DteSchemaResponseDto {

    @JsonProperty("identificacion")
    private DteIdentificationDto identification;

    @JsonProperty(value = "documentoRelacionado")
    private List<DteRelatedDocumentsDto> relatedDocuments;

    @JsonProperty("emisor")
    private DteTransmitterDto transmitter;

    @JsonProperty("receptor")
    private DteReceiverSaleDocumentDto receiver;

    @JsonProperty(value = "otrosDocumentos")
    private Object otherDocuments;

    @JsonProperty(value = "ventaTercero")
    private Object thirdPartySale;

    @JsonProperty("cuerpoDocumento")
    private List<DteDocumentBodyDto> body;

    @JsonProperty("resumen")
    private DteSummarySaleDocumentDto summary;

    @JsonProperty(value = "apendice")
    private List<DteAppendixDto> appendix;

}
