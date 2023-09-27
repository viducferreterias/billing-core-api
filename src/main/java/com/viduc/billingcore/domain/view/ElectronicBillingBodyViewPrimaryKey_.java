package com.viduc.billingcore.domain.view;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ElectronicBillingBodyViewPrimaryKey.class)
public class ElectronicBillingBodyViewPrimaryKey_ {

    public static volatile SingularAttribute<ElectronicBillingBodyViewPrimaryKey , Integer> companyId;
    public static volatile SingularAttribute<ElectronicBillingBodyViewPrimaryKey , Integer> pointSaleCode;
    public static volatile SingularAttribute<ElectronicBillingBodyViewPrimaryKey , Integer> documentTypeCode;
    public static volatile SingularAttribute<ElectronicBillingBodyViewPrimaryKey , Integer> documentNumber;
    public static volatile SingularAttribute<ElectronicBillingBodyView ,Integer> sequence;
    
}
