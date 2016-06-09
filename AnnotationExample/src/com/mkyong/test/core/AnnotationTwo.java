package com.mkyong.test.core;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level
public @interface AnnotationTwo {

	public enum Priority {
	   LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.MEDIUM;
	
	String[] tags() default "default_tags";
	
	String createdBy() default "default-createdby";
	
	String lastModified() default "03/01/2014";

}
