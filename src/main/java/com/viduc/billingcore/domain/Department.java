package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "deptos" , schema = "parametros")
public class Department implements Serializable {

    @EmbeddedId
    private DepartmentPrimaryKey id;

    @Column(name = "codigo_departamento_mh")
    private String departmentCodeMH;

}
