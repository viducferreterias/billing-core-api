package com.viduc.billingcore.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.viduc.billingcore.dto.components.DteExtensionDto;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@ToString(callSuper = true)
@SuperBuilder
public class DteSchemaCreditNoteResponseDto extends DteSchemaResponseDto{

    @JsonProperty(value = "extension")
    private DteExtensionDto extension;

}
