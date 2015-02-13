package com.bankht.monkey.dom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Dom2List {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		String xml = "<Body>" +
				"<EBList>" +
				"	<EBInfo>" +
				"		<IdNb>11111</IdNb>" +
				"		<BillAmt>999.9</BillAmt>" +
				"	</EBInfo>" +
				"</EBList>" +
				"</Body>";
		String xpath = "//Body/EBList/EBInfo";
		List resultList = new ArrayList();
		Document document = null;
		// String s="";
		try {
			document = DocumentHelper.parseText(xml);
		} catch (DocumentException e) {
		}
		List list = document.selectNodes(xpath);
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Element em = (Element) iter.next();
			Map m = resolveDomLowercaseInitial(em.asXML(), "/" + em.getName() + "/*");
			resultList.add(m);
		}
		
		System.out.println("ok");
	}
	
	static public Map<String, String> resolveDom(Document document, String xpath) {
		Map<String, String> resultMap = new HashMap<String, String>();
		List<Element> list = document.selectNodes(xpath);
		for (Iterator<Element> iter = list.iterator(); iter.hasNext();) {
			Element em = (Element) iter.next();
			resultMap.put(em.getName(), (String) em.getData());
		}
		return resultMap;
	}
	
	static public Map<String, String> resolveDom(String s, String xpath) throws Exception {
		Map<String, String> entity = new HashMap<String, String>();
		Document document = null;
		try {
			document = DocumentHelper.parseText(s);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		List<Element> list = document.selectNodes(xpath);
		for (Iterator<Element> iter = list.iterator(); iter.hasNext();) {
			Element node = iter.next();
			if (node.getData() != null && !node.getData().toString().trim().equals("")) {
				entity.put(node.getName(), (String) node.getData());
			}
		}
		return entity;
	}
	
	static public Map<String, String> resolveDomLowercaseInitial(String s, String xpath) throws Exception {
		Map<String, String> entity = new HashMap<String, String>();
		Document document = null;
		try {
			document = DocumentHelper.parseText(s);
		} catch (DocumentException e) {
		}
		List<Element> list = document.selectNodes(xpath);
		for (Iterator<Element> iter = list.iterator(); iter.hasNext();) {
			Element node = iter.next();
			if (node.getData() != null && !node.getData().toString().trim().equals("")) {
				entity.put(lowerCaseLetter(node.getName()), (String) node.getData());
			}
		}
		return entity;
	}
	
	private static String lowerCaseLetter(String aword) {
		byte[] i = aword.getBytes();
		if (i[0] > 64 && i[0] < 91) {
			i[0] += 32;
		}
		if(i[1]>64 &&i[1]<91){
			i[1]+=32;
		}
		return new String(i);
	}
}
