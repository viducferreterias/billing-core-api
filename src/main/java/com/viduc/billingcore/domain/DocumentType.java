package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "doctos_ctacte")
@AllArgsConstructor
@NoArgsConstructor
public class DocumentType implements Serializable {

    @Id
    @Column(name = "cod_doctoc")
    private Integer id;

    @Column(name = "nom_docto")
    private String description;

    @Column(name = "nomc_docto")
    private String abbreviation;

    @Column(name = "cod_cia")
    private Integer companyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentType that = (DocumentType) o;
        return Objects.equals(id, that.id) && Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, companyId);
    }
}
