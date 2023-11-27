package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DocumentType.class)
public class DocumentType_ {

    public static volatile SingularAttribute<DocumentType , Integer> id;
    public static volatile SingularAttribute<DocumentType , String> description;
    public static volatile SingularAttribute<DocumentType , String> abbreviation;
    public static volatile SingularAttribute<DocumentType , Integer> companyId;

}
