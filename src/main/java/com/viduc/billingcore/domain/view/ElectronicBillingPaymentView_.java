package com.viduc.billingcore.domain.view;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(ElectronicBillingPaymentView.class)
public class ElectronicBillingPaymentView_ {

    public static volatile SingularAttribute<ElectronicBillingPaymentView , ElectronicBillingPaymentViewPrimaryKey> id;
    public static volatile SingularAttribute<ElectronicBillingPaymentView , String> wayToPayCode;
    public static volatile SingularAttribute<ElectronicBillingPaymentView , LocalDateTime> documentDate;
    public static volatile SingularAttribute<ElectronicBillingPaymentView , Float> balance;
    public static volatile SingularAttribute<ElectronicBillingPaymentView , String> term;
    public static volatile SingularAttribute<ElectronicBillingPaymentView , Integer> periodTerm;

}
