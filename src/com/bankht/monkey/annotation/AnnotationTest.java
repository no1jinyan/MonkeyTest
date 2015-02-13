package com.bankht.monkey.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.apache.ibatis.binding.MapperMethod.MethodSignature;

import com.bankht.monkey.annotation.define.Greeting;
import com.bankht.monkey.annotation.define.MyAnnotation;

public class AnnotationTest {
	@MyAnnotation("first test")
	public static void main(String[] args) {
		try {
			SayHello();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@MyAnnotation(value = "3434")
	private static void SayHello() throws Exception {
		Class<?> clazz = Class.forName(
			"com.bankht.monkey.annotation.AnnotationPojo");
		Object object = clazz.newInstance();
		Method[] methods = clazz.getDeclaredMethods();

		Annotation[] annotations;

		for (Method method : methods) {
			annotations = method.getAnnotations();
			for (Annotation annotation : annotations) {
				System.out.println(method.getName() + " - "
						+ annotation.annotationType().getName());
				
			}
			if(method.isAnnotationPresent(Greeting.class)){
				Greeting greeting = method.getAnnotation(Greeting.class);
				System.out.println(greeting.name() + " : " + greeting.context() + " £º" + greeting.fontColor());
			}
			
			if(method.getName().equals("toString")){
				method.invoke(object, null);
			}
		}
	}

}
