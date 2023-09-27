package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "inven" , name = "inv_movm")
public class InventoryMovement implements Serializable {

    @EmbeddedId
    private InventoryMovementPrimaryKey id;

    @Column(name = "fecha_docto")
    private LocalDateTime issuedOn;

    @Column(name = "numero_control")
    private String controlNumber;

    @Column(name = "codigo_generacion")
    private String generationCode;

    @Column(name = "version_documento_electronico")
    private Integer taxDocumentVersion;

    @Column(name = "modelo_facturacion")
    private Integer billingModel;

    @Column(name = "tipo_transmision")
    private Integer transmissionType;

    @Column(name = "tipo_contingencia")
    private Integer contingencyType;

    @Column(name = "motivo_contingencia")
    private String contingencyReason;

    @Column(name = "total")
    private Float total;

    @Column(name = "sub_total")
    private Float subtotal;

    @Column(name = "cod_bodega_orig")
    private Integer destinationWarehouse;

    @Column(name = "cod_sucursal")
    private Integer originAgency;

    @Column(name = "cod_sucursal_destino")
    private Integer destinationAgency;

    @Column(name = "entregado_a")
    private Integer receivedBy;

    @OneToOne
    @JoinColumn(name = "cod_cia" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    private Company company;

    @OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_punto_venta" , referencedColumnName = "cod_sucursal" , insertable = false , updatable = false)
    private PointSale pointSale;

}
