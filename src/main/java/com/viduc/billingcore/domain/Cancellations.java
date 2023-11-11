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
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "anulaciones")
public class Cancellations implements Serializable {

    @Id
    @Column(name = "anulacion_id")
    private Integer id;

    @Column(name = "tipo_documento")
    private Integer documentType;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Column(name = "codigo_sucursal")
    private Integer pointSale;

    @Column(name = "fecha_emision")
    private LocalDateTime issueOn;

    @Column(name = "empresa_id")
    private Integer companyId;

    @Column(name = "sello_recepcion")
    private String receptionStamp;

    @Column(name = "codigo_generacion")
    private String generationCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancellations that = (Cancellations) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
