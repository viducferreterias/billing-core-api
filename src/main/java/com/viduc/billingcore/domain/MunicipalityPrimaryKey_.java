package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(MunicipalityPrimaryKey.class)
public class MunicipalityPrimaryKey_ {

    public static volatile SingularAttribute<Municipality , Integer> countryCode;
    public static volatile SingularAttribute<Municipality , Integer> departmentCode;
    public static volatile SingularAttribute<Municipality , Integer> municipalityCode;

}
