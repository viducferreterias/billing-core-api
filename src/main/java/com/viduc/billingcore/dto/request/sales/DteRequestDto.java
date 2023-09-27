package com.viduc.billingcore.dto.request.sales;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class DteRequestDto {

    private Integer posId;
    private Integer documentType;
    private Integer documentNumber;
    private LocalDateTime date;
    private Integer companyId;
    private Integer warehouseOrigin;

    public DteRequestDto(Integer posId, Integer documentType, Integer documentNumber, LocalDateTime date, Integer companyId) {
        this.posId = posId;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.date = date;
        this.companyId = companyId;
    }

    public DteRequestDto(Integer documentType, Integer documentNumber, LocalDateTime date, Integer companyId, Integer warehouseOrigin) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.date = date;
        this.companyId = companyId;
        this.warehouseOrigin = warehouseOrigin;
    }
}
