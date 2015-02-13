package com.bankht.monkey.designmodel;

/**
 * 适配器模式（Adapter）
 * 在原类型不做任何改变的情况下，用一个适配器类把一个接口转成另一个接口，扩展了新的接口，灵活且多样的适配一切旧俗。
 * 这种打破旧框框，适配新格局的思想，是面向对象的精髓。以继承方式实现的类的
 * Adapter模式和以聚合方式实现的对象的Adapter模式，各有千秋，各取所长。
 * 
 * @author Monkey
 * 
 */
public class TestAdapter {
	public static void main(String[] args) {
		USB mouse = new Mouse();
		PC pc = new PC();
		// pc.useMouse(mouse);
		PS2 adapter = new USB2PS2Adapter(mouse);
		pc.useMouse(adapter);
	}
}

interface PS2 {
	void usePs2();
}

interface USB {
	void useUsb();
}

class Mouse implements USB {
	public void useUsb() {
		System.out.println("通过USB接口工作");
	}
}

class PC {
	public void useMouse(PS2 ps2Mouse) {
		ps2Mouse.usePs2();
	}
}

class USB2PS2Adapter implements PS2 {
	private USB usb;
	public USB2PS2Adapter(USB usb) {
		this.usb = usb;
	}
	public void usePs2() {
		System.out.println("把对usePS2的方法调用转换成对useUSB的方法调用");
		usb.useUsb();
	}
}
