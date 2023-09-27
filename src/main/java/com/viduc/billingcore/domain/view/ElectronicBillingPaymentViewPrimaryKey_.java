package com.viduc.billingcore.domain.view;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ElectronicBillingPaymentViewPrimaryKey.class)
public class ElectronicBillingPaymentViewPrimaryKey_ {

    public static volatile SingularAttribute<ElectronicBillingPaymentViewPrimaryKey , Integer> companyId;
    public static volatile SingularAttribute<ElectronicBillingPaymentViewPrimaryKey , Integer> pointSaleCode;
    public static volatile SingularAttribute<ElectronicBillingPaymentViewPrimaryKey , Integer> documentTypeCode;
    public static volatile SingularAttribute<ElectronicBillingPaymentViewPrimaryKey , Integer> documentNumber;

}
