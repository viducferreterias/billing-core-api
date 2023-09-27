package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@ToString
@SuperBuilder
public class DteSchemaTaxReceiptResponseDto extends DteSchemaResponseDto{

    @JsonProperty(value = "extension")
    private DteExtensionDto extension;

}
