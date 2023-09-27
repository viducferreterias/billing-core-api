package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.DteExtensionDto;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class DteSchemaBillResponseDto extends DteSchemaResponseDto{

    @JsonProperty(value = "extension")
    private DteExtensionDto extension;

}
