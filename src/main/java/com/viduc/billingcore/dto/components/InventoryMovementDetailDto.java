package com.viduc.billingcore.dto.components;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public class InventoryMovementDetailDto {

    private String productCode;
    private String productDescription;
    private String idPresentationMh;
    private Integer sequence;
    private Integer productType;
    private Float quantity;
    private Float cost;
    private Float total;

}
