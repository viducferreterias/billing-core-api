package com.viduc.billingcore.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "v_cfe_factur_resum_forma_pago")
public class ElectronicBillingPaymentView implements Serializable {

    @EmbeddedId
    private ElectronicBillingPaymentViewPrimaryKey id;

    @Column(name = "fecha_documento")
    private LocalDateTime documentDate;

    @Column(name = "codigo_forma_pago")
    private String wayToPayCode;

    @Column(name = "saldo")
    private Float balance;

    @Column(name = "plazo")
    private String term;

    @Column(name = "periodo_plazo")
    private Integer periodTerm;

}
