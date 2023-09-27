package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(InventoryMovementDetailPrimaryKey.class)
public class InventoryMovementDetailPrimaryKey_ {

    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey ,Integer> type;
    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey ,Integer> number;
    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey , String> productCode;
    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey ,Integer> warehouse;
    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey ,Integer> companyId;
    public static volatile SingularAttribute<InventoryMovementDetailPrimaryKey , Integer> sequence;

}
