package com.viduc.billingcore.domain;

import com.viduc.billingcore.domain.view.ElectronicBillingSummaryView;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "vta_movm")
public class Sales implements Serializable {

    @EmbeddedId
    private SalesPrimaryKey id;

    @Column(name = "doc_stat")
    private String state;

    @Column(name = "fecha_docto")
    private LocalDateTime documentDate;

    @Column(name = "cod_cliente")
    private String clientCode;

    @Column(name = "nit")
    private String nit;

    @Column(name = "n_registro")
    private String nrc;

    @Column(name = "num_doc_iden")
    private String dui;

    @Column(name = "cod_vendedor")
    private String vendorCode;

    @Column(name = "cod_motorista")
    private String orderNumber;

    @Column(name = "numero_control")
    private String controlNumber;

    @Column(name = "codigo_generacion")
    private String generationCode;

    @Column(name = "observacion_1")
    private String comment1;

    @Column(name = "observacion_especial")
    private String specialComment;

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

    /*@Column(name = "iva")
    private Integer taxType;

    @Column(name = "sub_total")
    private Float subtotal;

    @Column(name = "percepcion")
    private Float perception;

    @Column(name = "fovial")
    private Float retention;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cliente" , insertable = false , updatable = false)
    @ToString.Exclude
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cia" , insertable = false , updatable = false)
    @ToString.Exclude
    private Company company;

    @OneToOne
    @JoinColumns({
            @JoinColumn(name = "cod_cia" , referencedColumnName = "empresa_id"),
            @JoinColumn(name = "cod_sucursal" , referencedColumnName = "codigo_sucursal"),
            @JoinColumn(name = "cod_doctoc" , referencedColumnName = "tipo_documento"),
            @JoinColumn(name = "num_docto" , referencedColumnName = "numero_documento")
    })
    private ElectronicBillingSummaryView electronicBillingSummary;

    @OneToOne
    @JoinColumn(name = "cod_sucursal" , referencedColumnName = "cod_sucursal" , insertable = false , updatable = false)
    private PointSale pointSale;

}
