/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1214
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-上午11:54:37
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1214;

import java.util.Scanner;


/**
 * 类名称： Main
 * 类描述：
 * 创建人：黄传聪
 * 2014年10月15日 上午11:54:37
 * @version 1.0.0
 */
public class Main {

	
	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 上午10:31:54
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			
			if (n <= 0){
				System.out.println(0);
			} else {
				
				System.out.println(getUglyNum(n));
			}
		}
	}
	
	private static int getUglyNum(int index){
		
		if (index <= 0){
			return 0;
		}
		
		int[] uglyNums = new int[index];
		uglyNums[0] = 1;
		
		//下一个丑数存储的位置
		int next = 1;
		
		int index2 = 0, index3 = 0, index5 = 0;
		
		while (next < index){
			
			int ugly2 = uglyNums[index2] * 2, 
				ugly3 = uglyNums[index3] * 3,
				ugly5 = uglyNums[index5] * 5;
			
			int ugly = Math.min(ugly2, Math.min(ugly3, ugly5));
			uglyNums[next] = ugly;
			//修正index2,3,5的位置
			while (uglyNums[index2] * 2 <= ugly){
				++index2;
			}
			
			while (uglyNums[index3] * 3 <= ugly){
				++index3;
			}
			
			while (uglyNums[index5] * 5 <= ugly){
				++index5;
			}
			
			++next;
		}
		
		
		return uglyNums[index-1];
	}

}
