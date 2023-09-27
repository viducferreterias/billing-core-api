package com.viduc.billingcore.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ElectronicBillingPaymentViewPrimaryKey implements Serializable {

    @Column(name = "empresa_id")
    private Integer companyId;

    @Column(name = "codigo_sucursal")
    private Integer pointSaleCode;

    @Column(name = "tipo_documento")
    private Integer documentTypeCode;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicBillingPaymentViewPrimaryKey that = (ElectronicBillingPaymentViewPrimaryKey) o;
        return Objects.equals(companyId, that.companyId) && Objects.equals(pointSaleCode, that.pointSaleCode) && Objects.equals(documentTypeCode, that.documentTypeCode) && Objects.equals(documentNumber, that.documentNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, pointSaleCode, documentTypeCode, documentNumber);
    }
}
