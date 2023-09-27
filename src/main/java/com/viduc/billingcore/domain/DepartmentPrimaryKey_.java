package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DepartmentPrimaryKey.class)
public class DepartmentPrimaryKey_ {
    public static volatile SingularAttribute<DepartmentPrimaryKey , Integer> countryCode;
    public static volatile SingularAttribute<DepartmentPrimaryKey , Integer> departmentCode;

}
