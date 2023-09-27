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
@Getter
@Setter
@ToString
@Entity
@Table(schema = "inven" , name = "productos")
public class Product implements Serializable {

    @Id
    @Column(name = "cod_prod")
    private String code;

    @Column(name = "nombre")
    private String description;

    @Column(name = "tipo_producto")
    private Integer type;

    @Column(name = "cod_cia")
    private Integer companyId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

}
