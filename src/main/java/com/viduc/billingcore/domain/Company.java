package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.JoinColumnsOrFormulas;
import org.hibernate.annotations.JoinFormula;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cias")
public class Company implements Serializable {

    @Id
    @Column(name = "cod_cia")
    private Integer id;

    @Column(name = "razon_social")
    private String businessName;

    @Column(name = "nom_comercial")
    private String commercialName;

    @Column(name = "direc_empresa")
    private String address;

    @Column(name = "telef_empresa")
    private String phoneNumber;

    @Column(name = "nit_empresa")
    private String nit;

    @Column(name = "registo_iva")
    private String nrc;

    @Column(name = "giro")
    private String descriptionEconomicActivity;

    @Column(name = "cod_actividad_economica")
    private Integer economicActivityCode;

    @Column(name = "correo_face")
    private String email;

    @Column(name = "codigo_departamento")
    private Integer departmentCode;

    @Column(name = "codigo_municipio")
    private Integer municipalityCode;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "company")
    @ToString.Exclude
    private List<Sales> sales;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , updatable = false , insertable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "1" , referencedColumnName = "cod_pais")),
    })
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumnsOrFormulas({
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_departamento" , referencedColumnName = "cod_depto" , updatable = false , insertable = false)),
            @JoinColumnOrFormula(column = @JoinColumn(name = "codigo_municipio" , referencedColumnName = "cod_muni" , updatable = false , insertable = false)),
            @JoinColumnOrFormula(formula = @JoinFormula(value = "1" , referencedColumnName = "cod_pais")),
    })
    private Municipality municipality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
