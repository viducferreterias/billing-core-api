package com.viduc.billingcore.domain;

import com.viduc.billingcore.domain.view.ElectronicBillingSummaryView;
import jakarta.persistence.Column;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(Sales.class)
public class Sales_ {

    public static volatile SingularAttribute<Sales ,SalesPrimaryKey> id;
    public static volatile SingularAttribute<Sales ,String> state;
    public static volatile SingularAttribute<Sales ,LocalDateTime> documentDate;
    public static volatile SingularAttribute<Sales ,String> clientCode;
    public static volatile SingularAttribute<Sales ,String> nit;
    public static volatile SingularAttribute<Sales ,String> nrc;
    public static volatile SingularAttribute<Sales ,String> dui;
    public static volatile SingularAttribute<Sales ,String> vendorCode;
    public static volatile SingularAttribute<Sales ,String> orderNumber;
    public static volatile SingularAttribute<Sales ,String> controlNumber;
    public static volatile SingularAttribute<Sales ,String> generationCode;
    public static volatile SingularAttribute<Sales ,String> comment1;
    public static volatile SingularAttribute<Sales ,String> specialComment;
    public static volatile SingularAttribute<Sales , Client> client;
    public static volatile SingularAttribute<Sales , Company> company;
    public static volatile SingularAttribute<Sales , ElectronicBillingSummaryView> electronicBillingSummary;
    public static volatile SingularAttribute<Sales , PointSale> pointSale;
    public static volatile SingularAttribute<Sales , Integer> taxDocumentVersion;
    public static volatile SingularAttribute<Sales , Integer> billingModel;
    public static volatile SingularAttribute<Sales , Integer> transmissionType;
    public static volatile SingularAttribute<Sales , Integer> contingencyType;
    public static volatile SingularAttribute<Sales , String> contingencyReason;
    
}
