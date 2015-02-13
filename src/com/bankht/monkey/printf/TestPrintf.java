package com.bankht.monkey.printf;

public class TestPrintf {
	/*
	 * 在学习了V512工作室的JavaSE教程后，感觉System.out.printf()方法十分实用，
	 * 既吸收了C/C++里printf()方法的优点，又有自身的特殊用法，使它更加灵活和全 面。但是这个类在Java
	 * API中并没有详细介绍，所以想用这样一个列子来简单 介绍Java（1.6.03版本）中System.out.printf()方法的主要用法。
	 */
	public static void main(String[] args) {
		// 定义一些变量，用来格式化输出。
		double d = 345.678;
		String s = "你好！";
		int i = 1234;
		// "%"表示进行格式化输出，"%"之后的内容为格式的定义。
		System.out.printf("%f", d);// "f"表示格式化输出浮点数。
		System.out.println();
		System.out.printf("%9.2f", d);// "9.2"中的9表示输出的长度，2表示小数点后的位数。
		System.out.println();
		System.out.printf("%+9.2f", d);// "+"表示输出的数带正负号。
		System.out.println();
		System.out.printf("%-9.4f", d);// "-"表示输出的数左对齐（默认为右对齐）。
		System.out.println();
		System.out.printf("%+-9.3f", d);// "+-"表示输出的数带正负号且左对齐。
		System.out.println();
		System.out.printf("%d", i);// "d"表示输出十进制整数。
		System.out.println();
		System.out.printf("%o", i);// "o"表示输出八进制整数。
		System.out.println();
		System.out.printf("%x", i);// "x"表示输出十六进制整数。
		System.out.println();
		System.out.printf("%#x", i);// "#x"表示输出带有十六进制标志的整数。
		System.out.println();
		System.out.printf("%s", s);// "s"表示输出字符串。
		System.out.println();
		System.out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s", d, i, s);
		// 可以输出多个变量，注意顺序。
		System.out.println();
		System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x", i, s);
		// "X$"表示第几个变量。
	}
}
