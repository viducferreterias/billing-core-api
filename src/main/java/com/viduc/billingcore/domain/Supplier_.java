package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Supplier.class)
public class Supplier_ {

    public static volatile SingularAttribute<Supplier , String> id;
    public static volatile SingularAttribute<Supplier , String> name;
    public static volatile SingularAttribute<Supplier , String> address;
    public static volatile SingularAttribute<Supplier , String> phone;
    public static volatile SingularAttribute<Supplier , String> email;
    public static volatile SingularAttribute<Supplier , String> descriptionEconomicActivity;
    public static volatile SingularAttribute<Supplier , Integer> codeEconomicActivity;
    public static volatile SingularAttribute<Supplier , String> nit;
    public static volatile SingularAttribute<Supplier , String> nrc;
    public static volatile SingularAttribute<Supplier , Integer> countryCode;
    public static volatile SingularAttribute<Supplier , Integer> departmentCode;
    public static volatile SingularAttribute<Supplier , Integer> municipalityCode;
    public static volatile SingularAttribute<Supplier , Integer> companyId;
    public static volatile SingularAttribute<Supplier , Country> country;
    public static volatile SingularAttribute<Supplier , Department> department;
    public static volatile SingularAttribute<Supplier , Municipality> municipality;
    public static volatile SingularAttribute<Supplier , String> excludedSubject;
    public static volatile SingularAttribute<Supplier , String> identificationNumber;

}
