package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import jakarta.persistence.metamodel.StaticMetamodel;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sucursales")
public class PointSale implements Serializable {

    @Id
    @Column(name = "cod_sucursal")
    private Integer id;

    @Column(name = "estado")
    private String state;

    @Column(name = "tipo_establecimiento")
    private String establishmentType;

    @Column(name = "codigo_establecimiento_mh")
    private String establishmentCodeMH;

    @Column(name = "codigo_punto_venta_mh")
    private String pointSaleCodeMH;

    @Column(name = "nombre")
    private String description;

    @Column(name = "dir_sucursal")
    private String address;

    @Column(name = "tel_sucursal")
    private String phoneNumber;

    @Column(name = "cod_agencia")
    private Integer agencyCode;

    @Column(name = "cod_bodega")
    private Integer storeCode;

    @Column(name = "codigo_departamento")
    private Integer departmentCode;

    @Column(name = "codigo_municipio")
    private Integer municipalityCode;

    @Column(name = "cod_cia")
    private Integer companyId;

    @OneToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , insertable = false , updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "1" , referencedColumnName = "cod_pais"))
    })
    private Department department;

    @OneToOne
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , insertable = false , updatable = false)),
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_municipio" , referencedColumnName = "cod_muni" , insertable = false , updatable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "1" , referencedColumnName = "cod_pais"))
    })
    private Municipality municipality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointSale pointSale = (PointSale) o;
        return Objects.equals(id, pointSale.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
