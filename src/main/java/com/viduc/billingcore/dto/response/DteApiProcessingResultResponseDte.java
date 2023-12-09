package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DteApiProcessingResultResponseDte {

    @JsonProperty(value = "version")
    private Integer version;

    @JsonProperty(value = "ambiente")
    private String environment;

    @JsonProperty(value = "versionApp")
    private String applicationVersion;

    @JsonProperty(value = "estado")
    private String state;

    @JsonProperty("numeroControl")
    private String controlNumber;

    @JsonProperty(value = "codigoGeneracion")
    private String generationCode;

    @JsonProperty(value = "selloRecibido")
    private String receptionStamp;

    @JsonProperty(value = "fhProcesamiento")
    private String processingDate;

    @JsonProperty(value = "clasificaMsg")
    private String messageClassification;

    @JsonProperty(value = "codigoMsg")
    private String messageCode;

    @JsonProperty(value = "descripcionMsg")
    private String messageDescription;

    @JsonProperty(value = "observaciones")
    private List<String> observations;

}
