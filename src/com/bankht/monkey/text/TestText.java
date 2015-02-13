package com.bankht.monkey.text;

import org.apache.commons.lang.StringUtils;

public class TestText {
	public static void main(String[] args){
		String str = "36000.01";
		System.out.println(StringUtils.replace(str, "," , ""));
		System.out.println(str);
	}
}
