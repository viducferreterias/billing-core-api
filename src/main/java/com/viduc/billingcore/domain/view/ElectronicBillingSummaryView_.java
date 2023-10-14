package com.viduc.billingcore.domain.view;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(ElectronicBillingSummaryView.class)
public class ElectronicBillingSummaryView_ {

    public static volatile SingularAttribute<ElectronicBillingSummaryView , ElectronicBillingSummaryViewPrimaryKey> id;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , LocalDateTime> documentDate;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Integer> taxType;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> fullyExempt;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> totalTaxed;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> iva;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> subtotal;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> perception;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> retention;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> fullOperation;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> operatingCondition;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Integer> documentGenerationType;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> relatedDocumentNumber;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> relatedDocumentIssueDate;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , Float> totalPayment;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> totalWords;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> bondedWarehouseCode;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> exportRegimeCode;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> incotermsCode;
    public static volatile SingularAttribute<ElectronicBillingSummaryView , String> descriptionIncotermsCode;
    
}
