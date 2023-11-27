package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Seller.class)
public class Seller_ {

    public static volatile SingularAttribute<Seller , String> id;
    public static volatile SingularAttribute<Seller , String> name;
    public static volatile SingularAttribute<Seller , Integer> companyId;

}
