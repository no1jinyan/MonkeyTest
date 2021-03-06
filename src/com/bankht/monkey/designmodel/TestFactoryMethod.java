package com.bankht.monkey.designmodel;
/**
 * 工厂方法模式（Factory Method）
 * 将程序中创建对象的操作，单独出来处理，创建一个产品的工厂接口，把实际的工作转移到具体的子类。大大提高了系统扩展的柔性，接口的抽象化处理给相互依赖的对象创建提供了最好的抽象模式。
 * 
 * @author Monkey
 * 
 */
public class TestFactoryMethod {
	public static void main(String[] args) {
		AnimalFactory af = new DogFactory();
		Animal1 a = af.getAnimal();
	}
}

abstract class Animal1 {
}

class Dog1 extends Animal1 {
}

class Cat1 extends Animal1 {
}

abstract class AnimalFactory {
	public abstract Animal1 getAnimal();
}

class DogFactory extends AnimalFactory {
	public Animal1 getAnimal() {
		System.out.println("Dog");
		return new Dog1();
	}
}

class CatFactory extends AnimalFactory {
	public Animal1 getAnimal() {
		System.out.println("Cat");
		return new Cat1();
	}
}