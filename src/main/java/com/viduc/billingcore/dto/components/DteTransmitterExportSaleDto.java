package com.viduc.billingcore.dto.components;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteTransmitterExportSaleDto extends DteTransmitterDto{

    @JsonProperty(value = "tipoItemExpor")
    private String exportItemType;

    @JsonProperty(value = "recintoFiscal")
    private String bondedWarehouse;

    @JsonProperty(value = "regimen")
    private String exportRegime;

}
