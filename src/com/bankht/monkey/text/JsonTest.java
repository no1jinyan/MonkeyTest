package com.bankht.monkey.text;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "[{\"elecBillNo\":\"190745200001620100726000305703\",\"billAmt\":9999999999,\"billType\":\"AC01\",\"isseDate\":\"2010-07-26\",\"dueDate\":\"2011-01-26\",\"banEndoMark\":\"EM00\",\"eebRecvacctid\":\"44469101040001950\",\"eebRecvacctsvcr\":\"103588046700\",\"eebRecvname\":\"佛山市恒通伟业制冷配件有限公司\",\"issuerBankName\":\"中国农业银行佛山顺德大良支行\"}]";
		List list = getMapListForJson(str);
		System.out.println();
	}
	
	private static List<?> getMapListForJson(String json){
		JSONArray array = JSONArray.fromObject(json);
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		int ilen = array.size();
		for (int i = 0; i < ilen; i++) {
			JSONObject object = JSONObject.fromObject(array.get(i));
			Iterator<String> keyIter = object.keys();
			String key;
			Object value;
			Map<String, Object> valueMap = new HashMap<String, Object>();
			while (keyIter.hasNext()) {
				key = keyIter.next();
				value = object.get(key);
				if (value instanceof Double) {
					valueMap.put(key, getFormatDouble2(Double
							.parseDouble(value.toString())));
				} else {
					valueMap.put(key, value);
				}
			}
			result.add(valueMap);
			object = null;
		}
		
		array.clear();
		array = null;
		return result;
	}
	
	public static String getFormatDouble2(Double doubleValue) {
		NumberFormat doubleFormat2;
		doubleFormat2 = NumberFormat.getInstance();
		doubleFormat2.setGroupingUsed(false);
		doubleFormat2.setMaximumFractionDigits(2);
		doubleFormat2.setMinimumFractionDigits(2);
		if (doubleValue == null) {
			return null;
		} else {
			return doubleFormat2.format(doubleValue);
		}
	}

}
