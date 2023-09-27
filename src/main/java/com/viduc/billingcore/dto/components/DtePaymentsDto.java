package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
@SuperBuilder
public class DtePaymentsDto {

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("montoPago")
    private Float amount;

    @JsonProperty("referencia")
    private String reference;

    @JsonProperty("plazo")
    private String term;

    @JsonProperty("periodo")
    private Integer period;

}
