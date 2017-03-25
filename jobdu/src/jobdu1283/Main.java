/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1283
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-上午11:57:13
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1283;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


/**
 * 类名称： Main
 * 类描述：
 * 创建人：黄传聪
 * 2014年10月15日 上午11:57:13
 * @version 1.0.0
 */
public class Main {

	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 上午11:57:13
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			String str = scanner.next();
			
//			getFirst(str);
			getFirstWithArray(str);
		}
	}

	private static void getFirst(String str) {
		int length = str.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>(length);
		
		for (int i=0; i<length; ++i){
			
			Character key = str.charAt(i);
			int value = map.get(key)==null ? 0 : map.get(key);
			
			map.put(key, value + 1);
			
		}
		
		boolean flag = false;
		for (Entry e : map.entrySet()){
			
			if ((Integer)e.getValue() == 1){
				System.out.println(str.indexOf(String.valueOf(e.getKey())));
				flag = true;
				break;
			}
		}
		
		if (!flag){
			
			System.out.println(-1);
		}
	}
	
	
	//成功
	private static void getFirstWithArray (String str){
		
		if (str == null || str.length() <= 0){
			System.out.println(-1);
		}
		
		int length = str.length();
		
		//使用acicc码值
		int[] chs = new int[256];
		
		for (int i=0; i<length; ++i){
			++chs[str.charAt(i)];
		}
		
		for (int i=0; i<chs.length; ++i){
			if (chs[i] == 1){
				System.out.println(str.indexOf((char)i));
				
				return ;
			}
		}
		
		System.out.println(-1);
		
	}
	
	

}
