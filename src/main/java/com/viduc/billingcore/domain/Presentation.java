package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(schema = "inven" , name = "unidades_medida")
public class Presentation implements Serializable {

    @Id
    @Column(name = "id_unidad")
    private Integer id;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "abrev")
    private String abbreviation;

    @Column(name = "id_unidad_medida_mh")
    private String idPresentationMh;

    @Column(name = "cod_cia")
    private Integer companyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presentation that = (Presentation) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
