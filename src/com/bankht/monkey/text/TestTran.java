package com.bankht.monkey.text;

import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;

public class TestTran {
	//�ɱ����(Variable Arguments) 1.5������
	private static int add(int ... args){
		int result = 0;
		for(int temp : args){
			result += temp;
		}
		return result;		
	}
	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
//		System.out.println(StringUtils.substringBeforeLast("aaaa_bb", "_"));
		/**
		 * ת�����
		 */
//		String org = "%E5%88%98%E6%88%90%E6%88%90";
//		System.out.println(new String(org.getBytes("GB2312"), "utf-8"));
//		System.out.println(URLEncoder.encode(org));
//		System.out.println(java.net.URLDecoder.decode(org, "UTF-8"));
		/**
		 * string��split����
		 */
//		String a = "a,b,c ,";
//		String[] b = a.split(",");
//		System.out.println(b.length);
//		System.out.println("'" + b[2] + "'");
		
		/**
		 * StringUtils��isBlank��isEmpty����null�͡� ���Ĳ���
		 */
		System.out.println(StringUtils.isBlank(" "));
		System.out.println(StringUtils.isEmpty(" "));
		System.out.println(StringUtils.isBlank(null));
		System.out.println(StringUtils.isEmpty(null));
		
		/**
		 * string��substring����
		 */
//		String temp = "0123456";
//		System.out.println(temp.substring(0,2));
		
		
		//nλ�������ǰ��0
//		for (int i = 0; i < 100000; i++) {
//			String num = String.valueOf(Math.round(Math.random() * 10000000000d));
//			int length = num.length();
//			if(length != 10){
//				for (int j = 10; j > length; j--) {
//					num = "0" + num;
//				}
//			}
//			System.out.println(num);
//		}
		
//		System.out.println(add(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));		
		String str[] = {};
		try {
			str = StringUtils.split(null, "|");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(str != null)
			System.out.println(str.length);
		}
		
		
		if(true)return;
		
		
		/**
		 * 5ips.net�������򿪴���
		 */
		int bookNo = 108;//���
		int start = 181;//��ʼ��
		int end = 201;//������
		System.out.println("<script language=javascript>");
		for (int i = start; i <= end; i++) {
			String num = String.valueOf(i);
			int length = num.length();
			if(length != 3){
				for (int j = 3; j > length; j--) {
					num = "0" + num;
				}
			}
			System.out.println("window.open('http://www.5ips.net/down_" + bookNo + "_" + num + ".htm');");
		}
		System.out.println("</script>");
	}

}
