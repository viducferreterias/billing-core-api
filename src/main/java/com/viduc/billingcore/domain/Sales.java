package com.viduc.billingcore.domain;

import com.viduc.billingcore.domain.view.ElectronicBillingSummaryView;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import java.io.Serializable;
import java.time.LocalDate;
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

    @Column(name = "observacion")
    private String comment2;

    @Column(name = "txt_envios")
    private String comment3;

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

    @Column(name = "sello_recepcion_electronico")
    private String electronicReceiptSale;

    @Column(name = "iva")
    private Float iva;

    @Column(name = "sub_total")
    private Float subtotal;

    @Column(name = "percepcion")
    private Float perception;

    @Column(name = "fovial")
    private Float retention;

    @Column(name = "codigo_proveedor")
    private String providerCode;

    @Column(name = "numero_pedido")
    private String relatedInvoiceNumber;

    @Column(name = "fecha_ref")
    private LocalDate referenceDate;

    @Column(name = "impresion")
    private Integer impression;

    @Column(name = "procesado_el")
    private LocalDateTime processedThe;

    @ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_cliente" , insertable = false , updatable = false)
    @ToString.Exclude
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "cod_cia" , insertable = false , updatable = false)
    @ToString.Exclude
    private Company company;

    @OneToOne(fetch = FetchType.LAZY, optional = false , cascade = CascadeType.ALL)
    @ToString.Exclude
    @JoinColumn(name = "cod_cia" , referencedColumnName = "empresa_id" , insertable = false , updatable = false)
    @JoinColumn(name = "cod_sucursal" , referencedColumnName = "codigo_sucursal", insertable = false , updatable = false)
    @JoinColumn(name = "cod_doctoc" , referencedColumnName = "tipo_documento", insertable = false , updatable = false)
    @JoinColumn(name = "num_docto" , referencedColumnName = "numero_documento", insertable = false , updatable = false)
    private ElectronicBillingSummaryView electronicBillingSummary;

    @OneToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "cod_sucursal" , referencedColumnName = "cod_sucursal" , insertable = false , updatable = false)
    private PointSale pointSale;

    @OneToOne(fetch = FetchType.LAZY , optional = false)
    @JoinColumn(name = "codigo_proveedor" , referencedColumnName = "cod_prov" , insertable = false , updatable = false)
    @ToString.Exclude
    private Supplier supplier;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cia" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    @JoinColumn(name = "cod_vendedor" , referencedColumnName = "cod_vendedor" , insertable = false , updatable = false)
    private Seller seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_cia" , referencedColumnName = "cod_cia" , insertable = false , updatable = false)
    @JoinColumn(name = "cod_doctoc" , referencedColumnName = "cod_doctoc" , insertable = false , updatable = false)
    private DocumentType documentType;

}
