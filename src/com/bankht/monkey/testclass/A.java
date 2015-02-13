package com.bankht.jin.testclass;

import com.bankht.jin.testclass.abst.AbstractTestClass;

public class A {
	private String tepProp = "aaa";
	public String getTepProp() {
		return tepProp;
	}

	public void setTepProp(String tepProp) {
		this.tepProp = tepProp;
	}

	public A(){
		B b = new B();
		System.out.println(b.getSuperName());
	}
	
	public static void main(String[] args){
		AbstractTestClass aClass = new B();
		System.out.println(aClass.getClassName());		
	}
	
	public String getClassName(){
		return "I am A";
	}
	
	protected void getProtectedMethod(String args){
		System.out.println(args);
	}
	
	protected void getProtectedMethod(boolean arg){
		if(arg){
			System.out.println("this call private method is " + this.isPrivateMethod());
		}
	}
	
	private boolean isPrivateMethod(){
		return true;
	}
}

class B extends AbstractTestClass{
	@Override
	public String getClassName() {
		return "I am B";
	}
	
	public String getSuperName(){
		return super.getClassName(" ");
	}

	public void isInterFactImplement() {
		System.out.println("impl in B");
	}

}
