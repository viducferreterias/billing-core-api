package com.viduc.billingcore.domain.view;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "v_cfe_factur_cuerpo_documento")
public class ElectronicBillingBodyView implements Serializable {

    @EmbeddedId
    private ElectronicBillingBodyViewPrimaryKey id;

    @Column(name = "fecha_documento")
    private LocalDateTime documentDate;

    @Column(name = "numero_documento_relacionado")
    private String relatedDocumentNumber;

    @Column(name = "afecto")
    private Integer taxType;

    @Column(name = "tipo_producto")
    private Integer productType;

    @Column(name = "codigo_producto")
    private String productCode;

    @Column(name = "descripcion_producto")
    private String productDescription;

    @Column(name = "unidad_medida")
    private Integer measurementUnit;

    @Column(name = "precio_unitario")
    private Float unitPrice;

    @Column(name = "unidades")
    private Float units;

    @Column(name = "venta_gravada")
    private Float taxedSale;

    @Column(name = "venta_exenta")
    private Float untaxedSale;

    @Column(name = "total_item")
    private Float total;

    @Column(name = "iva")
    private Float iva;

}
