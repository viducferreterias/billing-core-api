package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@ToString
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class InventoryMovementDetailPrimaryKey implements Serializable {

    @Column(name = "cod_doctoi")
    private Integer type;

    @Column(name = "num_docto")
    private Integer number;

    @Column(name = "cod_prod")
    private String productCode;

    @Column(name = "cod_bodega")
    private Integer warehouse;

    @Column(name = "secuencia")
    private Integer sequence;

    @Column(name = "cod_cia")
    private Integer companyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InventoryMovementDetailPrimaryKey that = (InventoryMovementDetailPrimaryKey) o;
        return Objects.equals(type, that.type) && Objects.equals(number, that.number) && Objects.equals(warehouse, that.warehouse) && Objects.equals(sequence, that.sequence) && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, number, warehouse, sequence, companyId);
    }
}
