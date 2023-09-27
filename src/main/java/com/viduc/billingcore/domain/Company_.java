package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.util.List;

@StaticMetamodel(Company.class)
public class Company_ {

    public static volatile SingularAttribute<Company , Integer> id;
    public static volatile SingularAttribute<Company , String> businessName;
    public static volatile SingularAttribute<Company , String> commercialName;
    public static volatile SingularAttribute<Company , String> address;
    public static volatile SingularAttribute<Company , String> phoneNumber;
    public static volatile SingularAttribute<Company , String> nit;
    public static volatile SingularAttribute<Company , String> nrc;
    public static volatile SingularAttribute<Company , String> descriptionEconomicActivity;
    public static volatile SingularAttribute<Company , Integer> economicActivityCode;
    public static volatile SingularAttribute<Company , String> email;
    public static volatile SingularAttribute<Company , Integer> departmentCode;
    public static volatile SingularAttribute<Company , Integer> municipalityCode;

    public static volatile SingularAttribute<Company , List<Sales>> sales;
    public static volatile SingularAttribute<Company , Department> department;
    public static volatile SingularAttribute<Company , Municipality> municipality;
    
}
