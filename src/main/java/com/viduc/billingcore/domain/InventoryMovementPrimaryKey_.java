package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(InventoryMovementPrimaryKey.class)
public class InventoryMovementPrimaryKey_ {

    public static volatile SingularAttribute<InventoryMovementPrimaryKey ,Integer> type;
    public static volatile SingularAttribute<InventoryMovementPrimaryKey ,Integer> number;
    public static volatile SingularAttribute<InventoryMovementPrimaryKey ,Integer> warehouse;
    public static volatile SingularAttribute<InventoryMovementPrimaryKey ,Integer> companyId;

}
