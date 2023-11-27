package com.viduc.billingcore.domain;

import com.viduc.billingcore.domain.view.ElectronicBillingSummaryView;
import com.viduc.billingcore.utils.enums.DocumentType;
import jakarta.persistence.Column;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDate;
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
    public static volatile SingularAttribute<Sales , String> electronicReceiptSale;
    public static volatile SingularAttribute<Sales , String> comment2;
    public static volatile SingularAttribute<Sales , String> comment3;
    public static volatile SingularAttribute<Sales , Float> iva;

    public static volatile SingularAttribute<Sales , Float> subtotal;
    public static volatile SingularAttribute<Sales , Float> perception;
    public static volatile SingularAttribute<Sales , Float> retention;
    public static volatile SingularAttribute<Sales , String> providerCode;
    public static volatile SingularAttribute<Sales , String> relatedInvoiceNumber;
    public static volatile SingularAttribute<Sales , Integer> impression;
    public static volatile SingularAttribute<Sales , Supplier> supplier;
    public static volatile SingularAttribute<Sales , LocalDate> referenceDate;
    public static volatile SingularAttribute<Sales , Seller> seller;
    public static volatile SingularAttribute<Sales , DocumentType> documentType;

    
}
