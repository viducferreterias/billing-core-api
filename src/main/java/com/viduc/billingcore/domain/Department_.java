package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Department.class)
public class Department_ {

    public static volatile SingularAttribute<Department , DepartmentPrimaryKey> id;
    public static volatile SingularAttribute<Department , String> departmentCodeMH;

}
