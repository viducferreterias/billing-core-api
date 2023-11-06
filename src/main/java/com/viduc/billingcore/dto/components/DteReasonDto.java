package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteReasonDto {

    @JsonProperty(value = "tipoAnulacion")
    private Integer type;

    @JsonProperty(value = "motivoAnulacion")
    private String descriptionReason;

    @JsonProperty(value = "nombreResponsable")
    private String responsibleName;

    @JsonProperty(value = "tipDocResponsable")
    private String responsibleDocumentType;

    @JsonProperty(value = "numDocResponsable")
    private String responsibleDocumentNumber;

    @JsonProperty(value = "nombreSolicita")
    private String applicantName;

    @JsonProperty(value = "tipDocSolicita")
    private String applicantDocumentType;

    @JsonProperty(value = "numDocSolicita")
    private String applicantDocumentNumber;

}
