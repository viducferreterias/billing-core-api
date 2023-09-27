package com.viduc.billingcore.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
public class ElectronicBillingBodyViewPrimaryKey implements Serializable {

    @Column(name = "empresa_id")
    private Integer companyId;

    @Column(name = "codigo_sucursal")
    private Integer pointSaleCode;

    @Column(name = "tipo_documento")
    private Integer documentTypeCode;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Column(name = "secuencia")
    private Integer sequence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicBillingBodyViewPrimaryKey that = (ElectronicBillingBodyViewPrimaryKey) o;
        return Objects.equals(companyId, that.companyId) && Objects.equals(pointSaleCode, that.pointSaleCode) && Objects.equals(documentTypeCode, that.documentTypeCode) && Objects.equals(documentNumber, that.documentNumber) && Objects.equals(sequence, that.sequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, pointSaleCode, documentTypeCode, documentNumber, sequence);
    }
}
