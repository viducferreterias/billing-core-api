package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(schema = "cxp" , name = "proveedores")
public class Supplier implements Serializable {

    @Id
    @Column(name = "cod_prov")
    private String id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "direccion")
    private String address;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "correo_electronico")
    private String email;

    @Column(name = "giro")
    private String descriptionEconomicActivity;

    @Column(name = "codigo_actividad_economica")
    private Integer codeEconomicActivity;

    @Column(name = "nit")
    private String nit;

    @Column(name = "no_registro")
    private String nrc;

    @Column(name = "cod_pais")
    private Integer countryCode;

    @Column(name = "codigo_departamento")
    private Integer departmentCode;

    @Column(name = "codigo_municipio")
    private Integer municipalityCode;

    @Column(name = "cod_cia")
    private Integer companyId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , insertable = false , updatable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , updatable = false , insertable = false),
            @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , updatable = false , insertable = false)
    })
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , updatable = false , insertable = false),
            @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , updatable = false , insertable = false),
            @JoinColumn(name = "codigo_municipio" , referencedColumnName = "cod_muni" , updatable = false , insertable = false)
    })
    private Municipality municipality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
