package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Table(name = "clientes")
public class Client implements Serializable {

    @Id
    @Column(name = "cod_cliente")
    private String code;

    @Column(name = "nom_cliente")
    private String name;

    @Column(name = "nom_comercial")
    private String commercialName;

    @Column(name = "dir_cobro")
    private String address;

    @Column(name = "cod_actividad_economica")
    private Integer economicActivityCode;

    @Column(name = "giro")
    private String descriptionEconomicActivity;

    @Column(name = "n_registro")
    private String nrc;

    @Column(name = "nit")
    private String nit;

    @Column(name = "dui")
    private String dui;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "telefonos")
    private String phone;

    @Column(name = "dias_cred")
    private Integer creditDays;

    @Column(name = "cod_pais")
    private Integer countryCode;

    @Column(name = "cod_depto")
    private Integer departmentCode;

    @Column(name = "cod_muni")
    private Integer municipalityCode;

    @Column(name = "tipo_persona")
    private Integer personType;

    @Column(name = "cod_cia")
    private Integer companyId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "client")
    @ToString.Exclude
    private List<Sales> sales;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_depto" , referencedColumnName = "cod_depto" , updatable = false , insertable = false),
            @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , updatable = false , insertable = false)
    })
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_depto" , referencedColumnName = "cod_depto" , updatable = false , insertable = false),
            @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , updatable = false , insertable = false),
            @JoinColumn(name = "cod_muni" , referencedColumnName = "cod_muni" , updatable = false , insertable = false)
    })
    private Municipality municipality;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_pais" , referencedColumnName = "cod_pais" , updatable = false , insertable = false)
    private Country country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(code, client.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
