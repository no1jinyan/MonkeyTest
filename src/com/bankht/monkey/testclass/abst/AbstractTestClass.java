package com.bankht.jin.testclass.abst;

import com.bankht.jin.testclass.inte.InterFaceTestClass;

public abstract class AbstractTestClass implements InterFaceTestClass{
	private String className = "AbstractTestClass";
	
	public abstract void isInterFactImplement();
	
	public abstract String getClassName();
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getClassName(String arg){
		return this.className;
	}
}
