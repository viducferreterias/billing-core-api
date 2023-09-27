package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Presentation.class)
public class Presentation_ {

    public static volatile SingularAttribute<Presentation , Integer> id;
    public static volatile SingularAttribute<Presentation , String> description;
    public static volatile SingularAttribute<Presentation , String> abbreviation;
    public static volatile SingularAttribute<Presentation , Integer> companyId;
    public static volatile SingularAttribute<Presentation , String> idPresentationMh;

}
