package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "log_transmision_dte")
public class DteTransmissionLog implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "g_log_id")
    @SequenceGenerator(name = "g_log_id" , sequenceName = "s_log_transmision_dte_id" , initialValue = 1 , allocationSize = 1)
    @Column(name = "log_id")
    private Integer id;

    @Column(name = "empresa_id")
    private Integer companyId;

    @Column(name = "tipo_documento")
    private Integer documentType;

    @Column(name = "codigo_sucursal")
    private Integer branchCode;

    @Column(name = "codigo_bodega")
    private Integer warehouseCode;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Column(name = "fecha_emision")
    private LocalDateTime documentIssueDate;

    @Column(name = "procesado_el")
    private LocalDateTime processedThe;

    @Column(name = "descripcion_estado_mh")
    private String descriptionConditionMh;

    @Column(name = "observaciones_mh")
    private String observationsMh;

    @Column(name = "creado_el")
    private LocalDateTime createdThe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DteTransmissionLog that = (DteTransmissionLog) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
