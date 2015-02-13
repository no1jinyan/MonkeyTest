package com.bankht.monkey.regex;

import java.util.regex.Pattern;

public class RegexTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern pattern = Pattern.compile("[, |]+");
		String[] strs = pattern.split("Java Hello World  Java,Hello,,World,|Sun");
		for (int i=0;i<strs.length;i++) {
		    System.out.println(strs[i]);
		} 
	}

}
