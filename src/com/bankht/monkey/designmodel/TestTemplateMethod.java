package com.bankht.monkey.designmodel;

/**
 * 模板方法（Template Method）
 * 准备一个抽象类，把部分确定的逻辑定义在某些方法中，用其他抽象方法实现剩余的逻辑。不同子类对这些逻辑有不同的实现。
 * 用法：定义多个抽象操作，定义并实现一个模板方法，将步骤放在这个具体方法里，推迟到子类实现。子类可以改变父类的可变部分，
 * 但不能改变模板方法所代表的顶级逻辑。
 * 
 * @author Monkey
 * 
 */
public class TestTemplateMethod {  
    public static void main(String[] args) {
		XiaoPin xp = new DaPuKe();
		xp.act();
	}
}

abstract class XiaoPin {
	public abstract void jiaoLiu();
	public abstract void xuShi();
	public abstract void gaoXiao();
	public abstract void shanQing();
	public final void act() {
		jiaoLiu();
		xuShi();
		gaoXiao();
		shanQing();
	}
}

class DaPuKe extends XiaoPin {
	public void jiaoLiu() {
		System.out.println("顺口溜");
	}
	public void xuShi() {
		System.out.println("火车除夕，老同学见面");
	}
	public void gaoXiao() {
		System.out.println("名片当作扑克");
	}
	public void shanQing() {
		System.out.println("马家军");
	}
}   