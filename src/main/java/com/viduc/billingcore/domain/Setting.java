package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(schema = "parametros" , name = "configuracion")
public class Setting implements Serializable {

    @Id
    @Column(name = "configuracion_id")
    private Integer id;

    @Column(name = "configuracion")
    private String configuration;

    @Column(name = "valor1")
    private String value1;

    @Column(name = "valor2")
    private String value2;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "activo")
    private Integer state;

    @Column(name = "aplicacion")
    private String application;

    @Column(name = "modulo")
    private String module;

    @Column(name = "parametro")
    private Integer parameter;

    @Column(name = "orden")
    private Integer order;

    @Column(name = "formato")
    private String format;

    @Column(name = "tipo")
    private String type;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Setting setting = (Setting) o;
        return Objects.equals(id, setting.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
