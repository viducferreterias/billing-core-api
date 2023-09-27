package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class DepartmentPrimaryKey implements Serializable{

        @Column(name = "cod_pais")
        private Integer countryCode;

        @Column(name = "cod_depto")
        private Integer departmentCode;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            DepartmentPrimaryKey that = (DepartmentPrimaryKey) o;
            return Objects.equals(countryCode, that.countryCode) && Objects.equals(departmentCode, that.departmentCode);
        }

        @Override
        public int hashCode() {
            return Objects.hash(countryCode, departmentCode);
        }

}
