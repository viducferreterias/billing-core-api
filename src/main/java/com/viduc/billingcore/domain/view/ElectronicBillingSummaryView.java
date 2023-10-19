package com.viduc.billingcore.domain.view;

import com.viduc.billingcore.domain.Sales;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "v_cfe_factur_resumen_documento")
public class ElectronicBillingSummaryView implements Serializable {

    @EmbeddedId
    private ElectronicBillingSummaryViewPrimaryKey id;

    @Column(name = "fecha_documento")
    private LocalDateTime documentDate;

    @Column(name = "afecto")
    private Integer taxType;

    @Column(name = "codigo_recinto_fiscal")
    private String bondedWarehouseCode;

    @Column(name = "codigo_regimen_exportacion")
    private String exportRegimeCode;

    @Column(name = "codigo_incoterms")
    private String incotermsCode;

    @Column(name = "descripcion_codigo_incoterms")
    private String descriptionIncotermsCode;

    @Column(name = "tipo_generacion_documento")
    private Integer documentGenerationType;

    @Column(name = "numero_documento_relacionado")
    private String relatedDocumentNumber;

    @Column(name = "fecha_emision_docto_rel")
    private String relatedDocumentIssueDate;

    @Column(name = "sub_total")
    private Float subtotal;

    @Column(name = "percepcion")
    private Float perception;

    @Column(name = "retencion")
    private Float retention;

    @Column(name = "total_exenta")
    private Float fullyExempt;

    @Column(name = "total_gravada")
    private Float totalTaxed;

    @Column(name = "iva")
    private Float iva;

    @Column(name = "total_operacion")
    private Float fullOperation;

    @Column(name = "condicion_operacion")
    private Float operatingCondition;

    @Column(name = "total_pagar")
    private Float totalPayment;

    @Column(name = "total_letras")
    private String totalWords;


}
