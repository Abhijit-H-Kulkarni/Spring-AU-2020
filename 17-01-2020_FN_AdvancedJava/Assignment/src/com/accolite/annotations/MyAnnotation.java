package com.accolite.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD) 
public @interface MyAnnotation {
	int age() default 0;  
}

class Hello{  
@MyAnnotation(age=10)  
public void sayHello(){System.out.println("Hello from annotation");}  
}