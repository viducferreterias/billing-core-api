package com.viduc.billingcore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@StaticMetamodel(Setting.class)
public class Setting_ {

    public static volatile SingularAttribute<Setting , Integer> id;
    public static volatile SingularAttribute<Setting , String> configuration;
    public static volatile SingularAttribute<Setting , String> value1;
    public static volatile SingularAttribute<Setting , String> value2;
    public static volatile SingularAttribute<Setting , String> description;
    public static volatile SingularAttribute<Setting , Integer> state;
    public static volatile SingularAttribute<Setting , String> application;
    public static volatile SingularAttribute<Setting , String> module;
    public static volatile SingularAttribute<Setting , Integer> parameter;
    public static volatile SingularAttribute<Setting , Integer> order;
    public static volatile SingularAttribute<Setting , String> format;
    public static volatile SingularAttribute<Setting , String> type;

}
