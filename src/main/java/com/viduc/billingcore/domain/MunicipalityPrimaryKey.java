package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MunicipalityPrimaryKey implements Serializable {

    @Column(name = "cod_pais")
    private Integer countryCode;
    @Column(name = "cod_depto")
    private Integer departmentCode;
    @Column(name = "cod_muni")
    private Integer municipalityCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MunicipalityPrimaryKey that = (MunicipalityPrimaryKey) o;
        return Objects.equals(countryCode, that.countryCode) && Objects.equals(departmentCode, that.departmentCode) && Objects.equals(municipalityCode, that.municipalityCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryCode, departmentCode, municipalityCode);
    }
}
