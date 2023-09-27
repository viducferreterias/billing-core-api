package com.viduc.billingcore.domain.view;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(ElectronicBillingBodyView.class)
public class ElectronicBillingBodyView_ {

    public static volatile SingularAttribute<ElectronicBillingBodyView ,ElectronicBillingBodyViewPrimaryKey> id;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,LocalDateTime> documentDate;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Integer> taxType;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,String> relatedDocumentNumber;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Integer> productType;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,String> productCode;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,String> productDescription;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Integer> measurementUnit;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Float> unitPrice;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Float> units;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Float> total;
    public static volatile SingularAttribute<ElectronicBillingBodyView , Float> taxedSale;
    public static volatile SingularAttribute<ElectronicBillingBodyView , Float> untaxedSale;
    public static volatile SingularAttribute<ElectronicBillingBodyView , Float> iva;

}
