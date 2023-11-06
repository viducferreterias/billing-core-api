package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Employees.class)
public class Employees_ {

    public static volatile SingularAttribute<Employees , String> id;
    public static volatile SingularAttribute<Employees , String> name;
    public static volatile SingularAttribute<Employees , String> lastname;
    public static volatile SingularAttribute<Employees , String> dui;
    public static volatile SingularAttribute<Company , Integer> companyId;
    
}
