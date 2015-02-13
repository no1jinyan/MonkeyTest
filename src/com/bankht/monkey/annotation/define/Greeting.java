package com.bankht.monkey.annotation.define;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * RetentionPolicy
 	SOURCE,// Annotation is discarded by the compiler
	CLASS,// Annotation is stored in the class file, but ignored by the VM
	RUNTIME// Annotation is stored in the class file and read by the VM
 */
@Retention(RetentionPolicy.RUNTIME)

/**
 * ElementType
	  TYPE,         // Class, interface, or enum (but not annotation)
	  FIELD,        // Field (including enumerated values)
	  METHOD,       // Method (does not include constructors)
	  PARAMETER,        // Method parameter
	  CONSTRUCTOR,      // Constructor
	  LOCAL_VARIABLE,   // Local variable or catch clause
	  ANNOTATION_TYPE,  // Annotation Types (meta-annotations)
	  PACKAGE       // Java package
 */
/**只允许Greeting注释标注在普通方法和构造函数上，使用在包申明、类名等时，会提示错误信息*/
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})

public @interface Greeting {
	public enum FontColor {RED, YELLOW, BLUE};
	
	String name();
	
	String context();
	
	FontColor fontColor() default FontColor.BLUE;	
}
