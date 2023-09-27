package com.viduc.billingcore.utils.qualifier;



import com.viduc.billingcore.utils.enums.DocumentType;
import jakarta.inject.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD , ElementType.TYPE , ElementType.METHOD , ElementType.CONSTRUCTOR})
public @interface TypeElectronicDocument {
    DocumentType value();
}
