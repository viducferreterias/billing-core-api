package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(DteTransmissionLog.class)
public class DteTransmissionLog_ {

    public static volatile SingularAttribute<DteTransmissionLog , Integer> id;
    public static volatile SingularAttribute<DteTransmissionLog , Integer> companyId;
    public static volatile SingularAttribute<DteTransmissionLog , Integer> documentType;
    public static volatile SingularAttribute<DteTransmissionLog , Integer> branchCode;
    public static volatile SingularAttribute<DteTransmissionLog , Integer> warehouseCode;
    public static volatile SingularAttribute<DteTransmissionLog , Integer> documentNumber;
    public static volatile SingularAttribute<DteTransmissionLog , LocalDateTime> documentIssueDate;
    public static volatile SingularAttribute<DteTransmissionLog , LocalDateTime> processedThe;
    public static volatile SingularAttribute<DteTransmissionLog , String> descriptionConditionMh;
    public static volatile SingularAttribute<DteTransmissionLog , String> observationsMh;
    public static volatile SingularAttribute<DteTransmissionLog , LocalDateTime> createdThe;
    
}
