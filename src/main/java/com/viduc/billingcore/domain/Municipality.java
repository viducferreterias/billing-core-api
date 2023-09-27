package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "municipios" , schema = "parametros")
public class Municipality implements Serializable {

    @EmbeddedId
    private MunicipalityPrimaryKey id;

    @Column(name = "codigo_municipio_mh")
    private String municipalityCodeMH;

}
