package com.viduc.billingcore.domain;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import java.awt.*;

@StaticMetamodel(PointSale.class)
public class PointSale_ {

    public static volatile SingularAttribute<PointSale , Integer> id;
    public static volatile SingularAttribute<PointSale , String> state;
    public static volatile SingularAttribute<PointSale , String> establishmentType;
    public static volatile SingularAttribute<PointSale , String> establishmentCodeMH;
    public static volatile SingularAttribute<PointSale , String> pointSaleCodeMH;
    public static volatile SingularAttribute<PointSale , String> description;
    public static volatile SingularAttribute<PointSale , String> address;
    public static volatile SingularAttribute<PointSale , String> phoneNumber;
    public static volatile SingularAttribute<PointSale , Integer> agencyCode;
    public static volatile SingularAttribute<PointSale , Integer> storeCode;
    public static volatile SingularAttribute<PointSale , Integer> departmentCode;
    public static volatile SingularAttribute<PointSale , Integer> municipalityCode;
    public static volatile SingularAttribute<PointSale , Integer> companyId;
    public static volatile SingularAttribute<PointSale , Department> department;
    public static volatile SingularAttribute<PointSale , Municipality> municipality;

}
