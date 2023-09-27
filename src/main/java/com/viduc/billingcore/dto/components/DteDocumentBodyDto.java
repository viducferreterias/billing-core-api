package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;

@Getter
@ToString
@SuperBuilder
public class DteDocumentBodyDto {

    @JsonProperty("numItem")
    private Integer itemNumber;

    @JsonProperty("cantidad")
    private Float quantity;

    @JsonProperty("codigo")
    private String code;

    @JsonProperty("uniMedida")
    private Integer unitMeasure;

    @JsonProperty("precioUni")
    private Float price;

    @JsonProperty("montoDescu")
    private Float discount;

    @JsonProperty("ventaGravada")
    private Float taxedSale;

    @JsonProperty("tributos")
    private ArrayList<String> tributes;


}
