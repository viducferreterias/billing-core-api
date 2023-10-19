package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(InventoryMovement.class)
public class InventoryMovement_ {

    public static volatile SingularAttribute<InventoryMovement ,InventoryMovementPrimaryKey> id;
    public static volatile SingularAttribute<InventoryMovement ,LocalDateTime> issuedOn;
    public static volatile SingularAttribute<InventoryMovement ,String> controlNumber;
    public static volatile SingularAttribute<InventoryMovement ,String> generationCode;
    public static volatile SingularAttribute<InventoryMovement ,Integer> taxDocumentVersion;
    public static volatile SingularAttribute<InventoryMovement ,Integer> billingModel;
    public static volatile SingularAttribute<InventoryMovement ,Integer> transmissionType;
    public static volatile SingularAttribute<InventoryMovement ,Integer> contingencyType;
    public static volatile SingularAttribute<InventoryMovement ,String> contingencyReason;

    public static volatile SingularAttribute<InventoryMovement , String> electronicReceiptSale;
    public static volatile SingularAttribute<InventoryMovement ,Float> total;
    public static volatile SingularAttribute<InventoryMovement ,Float> subtotal;
    public static volatile SingularAttribute<InventoryMovement ,Integer> destinationWarehouse;
    public static volatile SingularAttribute<InventoryMovement ,Integer> originAgency;
    public static volatile SingularAttribute<InventoryMovement ,Integer> destinationAgency;
    public static volatile SingularAttribute<InventoryMovement ,Integer> receivedBy;
    public static volatile SingularAttribute<InventoryMovement , Integer> impression;
    public static volatile SingularAttribute<InventoryMovement ,Company> company;
    public static volatile SingularAttribute<InventoryMovement ,PointSale> pointSale;

}
