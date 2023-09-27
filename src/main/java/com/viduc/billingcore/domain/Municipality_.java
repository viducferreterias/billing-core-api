package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Municipality.class)
public class Municipality_ {

    public static volatile SingularAttribute<Municipality , MunicipalityPrimaryKey> id;
    public static volatile SingularAttribute<Municipality , String> municipalityCodeMH;

}
