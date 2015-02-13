package com.bankht.jin.testclass.c;

import java.lang.reflect.Method;

import com.bankht.jin.testclass.A;
import com.bankht.jin.testclass.abst.AbstractTestClass;

public class C {
	@SuppressWarnings("unchecked")
	public static void main(String[] args1) throws Exception{
		A a = new A();
		//得到class中的method
//		B b = new B();
		System.out.println(a.getClass().getName());
		Class newClass = Class.forName(a.getClass().getName());
		Method[] temp = newClass.getDeclaredMethods();
		System.out.println(newClass.getMethods());
			
//		for(Method aa : temp){
//			String args = "";
//			for(Class ina : aa.getParameterTypes()){
//				if("".equals(args)){
//					args += ina.getName();
//				}
//				args += "," + ina.getName(); 
//			}
//			System.out.println(aa.getName() + "(" + args + ")");
//			System.out.println("---" + aa.toGenericString());
//		}
		
		
//		testA(new D());
	}
	
	public static void testA(Object obj){
		/**
		 * class.forname的测试
		 */
		try{
			Class classTest = Class.forName(obj.getClass().getName());
			AbstractTestClass aClass = (AbstractTestClass) classTest.newInstance();
			System.out.println(aClass.getClassName());
			aClass.isInterFactImplement();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
