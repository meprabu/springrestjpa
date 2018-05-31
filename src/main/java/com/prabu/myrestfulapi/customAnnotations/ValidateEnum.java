package com.prabu.myrestfulapi.customAnnotations;

import java.lang.annotation.Documented;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Documented
@Constraint(validatedBy = {EnumValueValidator.class})
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateEnum {
	
	
	public abstract String message() default "Invalid Enum value. Please check the Enum value entered.";
    
    public abstract Class<?>[] groups() default {};
 
    public abstract Class<? extends Payload>[] payload() default {};
    
    public abstract Class<? extends java.lang.Enum<?>> enumClass();
    
    public abstract boolean ignoreCase() default false;
	

}
