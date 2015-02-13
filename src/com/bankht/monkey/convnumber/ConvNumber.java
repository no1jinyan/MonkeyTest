package com.bankht.monkey.convnumber;

import java.text.NumberFormat;

import org.apache.commons.lang.StringUtils;

public class ConvNumber {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double num = 12423424.0; 
		 NumberFormat doubleFormat2;
		doubleFormat2 = NumberFormat.getInstance();
		doubleFormat2.setGroupingUsed(false);
		doubleFormat2.setMaximumFractionDigits(2);
		doubleFormat2.setMinimumFractionDigits(2);
		System.out.println(toChinese(doubleFormat2.format(num)));
	}
	
	public static String toChinese(String num){
		String chars = "¡„“º∑°»˛À¡ŒÈ¬Ω∆‚∞∆æ¡";
		String[] flag = {" ∞","∞€","«™","ÕÚ","“⁄"};
		
		if(Double.parseDouble(num) > Math.pow(10, 12) || Double.parseDouble(num) == 0){
			return "¡„";
		}
		
		String[] numArr = StringUtils.split(num, ".");
		String[] temp = {"",""};
		for(int j = 0; j < numArr.length; j++){
			for(int i = 0; i < numArr[j].length(); i++){
				temp[j] = temp[j] + chars.charAt(Integer.parseInt(String.valueOf(numArr[j].charAt(i))));
			}
		}
		return temp[0] + temp[1];
	}
}
