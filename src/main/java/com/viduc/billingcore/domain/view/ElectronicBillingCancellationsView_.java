package com.viduc.billingcore.domain.view;

import com.viduc.billingcore.domain.Client;
import com.viduc.billingcore.domain.Company;
import com.viduc.billingcore.domain.Employees;
import com.viduc.billingcore.domain.PointSale;
import com.viduc.billingcore.domain.view.ElectronicBillingCancellationsView;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.time.LocalDateTime;

@StaticMetamodel(ElectronicBillingCancellationsView.class)
public class ElectronicBillingCancellationsView_ {

    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Integer> id;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Integer> documentType;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Integer> documentNumber;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Integer> branchCode;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , LocalDateTime> invalidationGenerationDate;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, LocalDateTime> documentIssueDate;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> clientCode;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> generationCode;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , String> invalidationGenerationCode;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , String> controlNumber;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> receptionStamp;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> type;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> reason;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , Float> iva;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , Float> total;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> requestedBy;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> createdBy;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, LocalDateTime> createdThe;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Integer> companyId;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, String> module;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView, Company> company;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , PointSale> pointSale;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , Client> client;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , Employees> employeeRequestBy;
    public static volatile SingularAttribute<ElectronicBillingCancellationsView , Employees> employeeCreatedBy;

}
