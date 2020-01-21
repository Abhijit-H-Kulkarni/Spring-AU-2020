package com.accolite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface DemoAccolite {
	String res() default "Abhijit H Kulkarni";
}