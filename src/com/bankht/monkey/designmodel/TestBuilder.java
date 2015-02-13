package com.bankht.monkey.designmodel;

/**
 * 建造模式（Builder） 
 * 将一个对象的内部表象和建造过程分割，一个建造过程可以造出不同表象的对象。可简化为模版方法模式.
 *  
 * @author Monkey
 *
 */
public class TestBuilder {
	public static void main(String[] args) {
		Builder b = new BuilderImpl1();
		Director d = new Director(b);
		Product p = d.createProduct();
		p.toString();
	}
}

interface Builder {
	void buildPart1();
	void buildPart2();
	void buildPart3();
	Product getProduct();
}

class BuilderImpl1 implements Builder {
	public void buildPart1() {
		System.out.println("create part1");
	}
	public void buildPart2() {
		System.out.println("create part2");
	}
	public void buildPart3() {
		System.out.println("create part3");
	}
	public Product getProduct() {
		return new Product();
	}
}

class Director {
	Builder b;
	public Director(Builder b) {
		this.b = b;
	}
	public Product createProduct() {
		b.buildPart1();
		b.buildPart2();
		b.buildPart3();
		return b.getProduct();
	}
}

class Product {
}