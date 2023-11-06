package com.viduc.billingcore.domain.view;

import com.viduc.billingcore.domain.Client;
import com.viduc.billingcore.domain.Company;
import com.viduc.billingcore.domain.Employees;
import com.viduc.billingcore.domain.PointSale;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_cfe_anulacion")
public class ElectronicBillingCancellationsView implements Serializable {

    @Id
    @Column(name = "anulacion_id")
    private Integer id;

    @Column(name = "tipo_documento")
    private Integer documentType;

    @Column(name = "numero_documento")
    private Integer documentNumber;

    @Column(name = "codigo_sucursal")
    private Integer branchCode;

    @Column(name = "fecha_emision")
    private LocalDateTime documentIssueDate;

    @Column(name = "codigo_cliente")
    private String clientCode;

    @Column(name = "codigo_generacion_invalidacion")
    private String invalidationGenerationCode;

    @Column(name = "codigo_generacion")
    private String generationCode;

    @Column(name = "numero_control")
    private String controlNumber;

    @Column(name = "sello_recepcion_electronico")
    private String receptionStamp;

    @Column(name = "tipo")
    private String type;

    @Column(name = "motivo")
    private String reason;

    @Column(name = "iva")
    private Float iva;

    @Column(name = "total")
    private Float total;

    @Column(name = "solicitado_por")
    private String requestedBy;

    @Column(name = "creado_por")
    private String createdBy;

    @Column(name = "fecha_generacion_invalidacion")
    private LocalDateTime invalidationGenerationDate;

    @Column(name = "creado_el")
    private LocalDateTime createdThe;

    @Column(name = "empresa_id")
    private Integer companyId;

    @Column(name = "modulo")
    private String module;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empresa_id" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_sucursal" , referencedColumnName = "cod_sucursal" , insertable = false , updatable = false)
    @JoinColumn(name = "empresa_id" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private PointSale pointSale;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo_cliente" , referencedColumnName = "cod_cliente" , insertable = false , updatable = false)
    @JoinColumn(name = "empresa_id" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private Client client;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "solicitado_por" , referencedColumnName = "cod_emp" , insertable = false , updatable = false)
    @JoinColumn(name = "empresa_id" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private Employees employeeRequestBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creado_por" , referencedColumnName = "cod_emp" , insertable = false , updatable = false)
    @JoinColumn(name = "empresa_id" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private Employees employeeCreatedBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElectronicBillingCancellationsView that = (ElectronicBillingCancellationsView) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
