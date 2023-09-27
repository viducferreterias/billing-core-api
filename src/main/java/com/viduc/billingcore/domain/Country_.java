package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Country.class)
public class Country_ {

    public static volatile SingularAttribute<Country , Integer> id;
    public static volatile SingularAttribute<Country , String> description;
    public static volatile SingularAttribute<Country , String> countryCodeMH;

}
