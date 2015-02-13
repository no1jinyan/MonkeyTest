package com.bankht.monkey.doubleball;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoubleBall {
	public static int count1 = 0;
	public static List<Integer> getDoubleBall(List<Integer> temp){
		for(int i = temp.size(); i <6; i++){
			double random = Math.random();
			Integer num = Integer.valueOf(String.valueOf(Math.round(random *  33)));
			if(!temp.contains(num)){
				temp.add(num);
			}
		}
		count1++;
		return temp;
	}
	
	public static List<Integer> checkBall(List<Integer> temp){
//		除掉0
		for(int i = 0; i < temp.size(); i++){
			if(temp.get(i) == 0){
				temp.remove(i);
			}
		}
//		排序
		for(int i = 0; i < temp.size(); i++){
			for(int y = i + 1; y < temp.size(); y++){
				if(temp.get(i) > temp.get(y)){
					Integer z = temp.get(i);
					temp.set(i, temp.get(y));
					temp.set(y, z);
				}
			}
		}
		if(temp.size() < 6){
			temp = getDoubleBall(temp);
			checkBall(temp);
		}
		
		return temp;
	}
	
	public static String addShowCountInfo(List<Integer> list){
		int sum = 0;
		double avg = 0;
		int oddCount = 0;
		for(Integer num : list){
			sum+=num.intValue();
			if(num % 2 == 1){
				oddCount++;
			}
		}
		avg = sum / 6;
//		System.out.print("\t\tsum:" + sum + "\t\tavg:" + avg + "\t\toddCount" + oddCount);
		return "\t\tsum:" + sum + "\t\tavg:" + avg + "\t\toddCount" + oddCount;
	}
	public static Map<Integer, Integer> map;
	public static String get16() throws Exception{
		    List<Integer> balls = new ArrayList<Integer>();
			History history = new History();
			StringBuffer sb = new StringBuffer();
			map = new HashMap<Integer, Integer>();
			int i = 0;
			while(i < 16){
				balls = checkBall(new ArrayList<Integer>());
				//和以往所开的比较，相同5个以上的不要
				if(history.checkSameBall(balls) > 0){
					continue;
				}
				for(Integer num : balls){
//					System.out.print(num + "\t");
					sb.append(num + "\t");
					if(map.get(num) == null)
						map.put(num, 1);
					else
						map.put(num, map.get(num) + 1);
				}
//				addShowCountInfo(balls);
				sb.append(addShowCountInfo(balls));
//				System.out.println();
				sb.append("\n");
				i++;
			}
			return sb.toString();
	}
	
	public static void main(String[] args) throws Exception {
		String str = get16();
		for(;;){
			for(int i = 1; i <= 33; i++){
				if(map.get(i) == null){
					str = "";
					continue;
				}
				if(map.get(i) > 5 ){
					str = "";
					continue;
				}
			}
			if(!str.equals("")){
				System.out.println(str);
				System.out.println(count1);
				break;
			}else{
				str = get16();
			}
		}
	}
}


