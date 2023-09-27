package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.util.List;

@StaticMetamodel(Client.class)
public class Client_ {

    public static volatile SingularAttribute<Client , String> code;
    public static volatile SingularAttribute<Client , String> name;
    public static volatile SingularAttribute<Client , String> commercialName;
    public static volatile SingularAttribute<Client , String> address;
    public static volatile SingularAttribute<Client , Integer> economicActivityCode;
    public static volatile SingularAttribute<Client , String> descriptionEconomicActivity;
    public static volatile SingularAttribute<Client , String> nrc;
    public static volatile SingularAttribute<Client , String> nit;
    public static volatile SingularAttribute<Client , String> dui;
    public static volatile SingularAttribute<Client , String> email;
    public static volatile SingularAttribute<Client , String> phone;
    public static volatile SingularAttribute<Client , Integer> creditDays;
    public static volatile SingularAttribute<Client , Integer> personType;
    public static volatile SingularAttribute<Client , Integer> countryCode;
    public static volatile SingularAttribute<Client , Integer> departmentCode;
    public static volatile SingularAttribute<Client , Integer> municipalityCode;
    public static volatile SingularAttribute<Client , Integer> companyId;
    public static volatile SingularAttribute<Client , List<Sales>> sales;
    public static volatile SingularAttribute<Client , Department> department;
    public static volatile SingularAttribute<Client , Municipality> municipality;
    public static volatile SingularAttribute<Client , Country> country;
    
}
