package com.viduc.billingcore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(schema = "inven" , name = "inv_detm")
public class InventoryMovementDetail implements Serializable {

    @EmbeddedId
    private InventoryMovementDetailPrimaryKey id;

    @Column(name = "nombre")
    private String description;

    @Column(name = "id_unidad")
    private Integer presentationId;

    @Column(name = "cantidad")
    private Float quantity;

    @Column(name = "costo_unit")
    private Float cost;

    @Column(name = "total_op")
    private Float total;

    @OneToOne
    @JoinColumn(name = "id_unidad" , referencedColumnName = "id_unidad" , updatable = false , insertable = false)
    private Presentation presentation;

    @OneToOne
    @JoinColumn(name = "cod_prod" , referencedColumnName = "cod_prod" , updatable = false , insertable = false)
    private Product product;

}
