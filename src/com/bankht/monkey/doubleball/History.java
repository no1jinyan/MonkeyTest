package com.bankht.jin.doubleball;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class History {
	private List<List<Integer>> list = null;
	
	public History() throws Exception{
		list = new ArrayList<List<Integer>>();
		InputStream is = new FileInputStream(new File("ssq.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(is);
		HSSFSheet sheet = workbook.getSheetAt(0);
		for(int i = 1; i <= sheet.getLastRowNum(); i++){
			List<Integer> temp = new ArrayList<Integer>();
			HSSFRow row = sheet.getRow(i);
			int y = 2;
			while(y <= 7){
				temp.add((int)(Math.round(row.getCell(y).getNumericCellValue())));
				y++;
			}
			list.add(temp);
		}
	}
	/**
	 * �Ƚ���ʷ����Ĭ�Ϸ���������ʾ�ظ�list
	 * @param list
	 * @return
	 */
	public int checkSameBall(List<Integer> list){
		return checkSameBall(list, false);
	}
	/**
	 * �Ƚ���ʷ
	 * @param list
	 * @param flag �Ƿ���ʾ��ʷ�ظ�
	 * @return
	 */
	public int checkSameBall(List<Integer> list, boolean flag){
		int sameCount = 0;
		int sameNum = 5;
		for(List<Integer> temp : this.list){
			int count = 0;
			for(int i = 0; i < temp.size(); i++){
				for(int y = 0; y < list.size(); y++){
					if(temp.get(i).intValue() == list.get(y).intValue()){
						count++;
					}
				}
			}
			if(count >= sameNum){
				sameCount++;
				if(flag){
					System.out.print("\t\t");
					for(Integer a : temp){
						System.out.print(a + "\t");
					}
				}
			}
		}
		return sameCount;
	}
	
	public void showList(){
		Integer[] count = new Integer[34];
		for(List<Integer> a : list){
			for(Integer b : a){
//				System.out.print(b + "\t");
				if(count[b] == null) count[b] = 0;
				count[b] += 1;
			}
//			System.out.println(checkSameBall(a));
		}
//		for(int i = 1; i < count.length; i++){
//			System.out.println(i + "\t" + count[i]);
//		}
	}
	
	public static void main(String[] args){
		try {
			History history = new History();
			history.showList();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
