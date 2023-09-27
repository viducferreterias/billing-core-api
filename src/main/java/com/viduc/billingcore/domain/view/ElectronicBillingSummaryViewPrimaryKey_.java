package com.viduc.billingcore.domain.view;

import jakarta.persistence.Column;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(ElectronicBillingSummaryViewPrimaryKey.class)
public class ElectronicBillingSummaryViewPrimaryKey_ {
    public static volatile SingularAttribute<ElectronicBillingSummaryViewPrimaryKey , Integer> companyId;
    public static volatile SingularAttribute<ElectronicBillingSummaryViewPrimaryKey , Integer> pointSaleCode;
    public static volatile SingularAttribute<ElectronicBillingSummaryViewPrimaryKey , Integer> documentTypeCode;
    public static volatile SingularAttribute<ElectronicBillingSummaryViewPrimaryKey , Integer> documentNumber;

}
