package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {

    public static volatile SingularAttribute<Product , String> code;
    public static volatile SingularAttribute<Product , String> description;
    public static volatile SingularAttribute<Product , Integer> type;
    public static volatile SingularAttribute<Product , Integer> companyId;

}
