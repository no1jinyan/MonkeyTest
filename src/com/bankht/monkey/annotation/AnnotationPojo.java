package com.bankht.monkey.annotation;

import com.bankht.monkey.annotation.define.Greeting;
import com.bankht.monkey.annotation.define.Greeting.FontColor;

public class AnnotationPojo {
	private String name;
	@Greeting(context = "toString", name = "Constructor")
	public AnnotationPojo(){
		super();
	}
	
	@Override
	@Greeting(context = "toString", name = "Annotation", fontColor = FontColor.RED)
	public String toString(){
		System.out.println(this.getClass().getName());
		return this.getClass().getName();		
	}

	@Greeting(context = "getName", name = "Annotation", fontColor = FontColor.YELLOW)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
