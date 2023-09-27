package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(InventoryMovementDetail.class)
public class InventoryMovementDetail_ {

    public static volatile SingularAttribute<InventoryMovementDetail , InventoryMovementDetailPrimaryKey> id;

    public static volatile SingularAttribute<InventoryMovementDetail , String> description;
    public static volatile SingularAttribute<InventoryMovementDetail , Integer> presentationId;
    public static volatile SingularAttribute<InventoryMovementDetail , Float> quantity;
    public static volatile SingularAttribute<InventoryMovementDetail , Float> cost;
    public static volatile SingularAttribute<InventoryMovementDetail , Float> total;
    public static volatile SingularAttribute<InventoryMovementDetail , Presentation> presentation;
    public static volatile SingularAttribute<InventoryMovementDetail , Product> product;

}
