package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(SalesPrimaryKey.class)
public class SalesPrimaryKey_ {

    public static volatile SingularAttribute<SalesPrimaryKey ,Integer> companyId;
    public static volatile SingularAttribute<SalesPrimaryKey ,Integer> pointSaleCode;
    public static volatile SingularAttribute<SalesPrimaryKey ,Integer> documentTypeCode;
    public static volatile SingularAttribute<SalesPrimaryKey ,Integer> documentNumber;
    
}
