package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(Cancellations.class)
public class Cancellations_ {

    public static volatile SingularAttribute<Cancellations , Integer> id;
    public static volatile SingularAttribute<Cancellations , Integer> documentType;
    public static volatile SingularAttribute<Cancellations , Integer> pointSale;
    public static volatile SingularAttribute<Cancellations , Integer> documentNumber;
    public static volatile SingularAttribute<Cancellations , LocalDateTime> issueOn;
    public static volatile SingularAttribute<Cancellations , LocalDateTime> createThe;
    public static volatile SingularAttribute<Cancellations , String> receptionStamp;
    public static volatile SingularAttribute<Cancellations , String> generationCode;
    public static volatile SingularAttribute<Cancellations , Integer> companyId;
    public static volatile SingularAttribute<Cancellations , LocalDateTime> processedThe;

}
