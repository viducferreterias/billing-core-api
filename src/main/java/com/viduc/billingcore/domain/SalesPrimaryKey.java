package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class SalesPrimaryKey implements Serializable {

    @Column(name = "cod_cia")
    private Integer companyId;

    @Column(name = "cod_sucursal")
    private Integer pointSaleCode;

    @Column(name = "cod_doctoc")
    private Integer documentTypeCode;

    @Column(name = "num_docto")
    private Integer documentNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesPrimaryKey that = (SalesPrimaryKey) o;
        return Objects.equals(companyId, that.companyId) && Objects.equals(pointSaleCode, that.pointSaleCode) && Objects.equals(documentTypeCode, that.documentTypeCode) && Objects.equals(documentNumber, that.documentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, pointSaleCode, documentTypeCode, documentNumber);
    }
}
