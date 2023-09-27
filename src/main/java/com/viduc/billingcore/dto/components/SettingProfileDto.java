package com.viduc.billingcore.dto.components;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class SettingProfileDto {

    private String configuration;
    private Integer state;
    private String application;
    private String module;
    private Integer parameter;
    private Integer order;
    private String format;
    private String type;

}
