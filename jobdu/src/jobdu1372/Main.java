/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1372
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-下午12:29:56
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1372;

import java.util.Scanner;


/**
 * 类名称： Main
 * 类描述：
 * 创建人：黄传聪
 * 2014年10月15日 下午12:29:56
 * @version 1.0.0
 */
public class Main {

	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午12:29:56
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner (System.in);
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			if (n <= 0){
				break;
			}
			
			int[] array = new int[n];
			for (int i=0; i<n; ++i){
				array[i] = scanner.nextInt();
			}
			getMaxSubResult(array);
			
		}
	}

	
	/**方法描述：
	 * 子串的初始位置和结束位置未确定
	 * 方法名：getMaxSubResult
	 * @param array
	 * @return int
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午12:30:28
	 */
	private static void getMaxSubResult(int[] array){
		
		if (array == null || array.length <= 0){
			System.out.println(0);
		}
		
		int beginIndex = 0, endIndex = 0;
		
		int maxCount = Integer.MIN_VALUE ,
			currentCount = 0;
		
		int length = array.length;
		int tempStart = 0;
		for (int i=0; i<length; ++i){
			
			if (currentCount <= 0){
				currentCount = array[i];
				tempStart = i;
			
			} else {
				currentCount += array[i];
			}
			
			if (maxCount < currentCount){
				maxCount = currentCount;
				endIndex = i;
				beginIndex = tempStart;
			}
		}
		
		System.out.println( maxCount + " " + beginIndex + " " + endIndex);
		
	}
}
