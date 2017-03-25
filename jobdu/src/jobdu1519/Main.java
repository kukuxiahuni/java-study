/**
 * 文件名：Main.java
 * 所在包：jobdu1519
 * 日期：2014-10-13 下午1:45:46
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1519;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-13 下午1:45:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			int n = scanner.nextInt();
			
			int[] array = new int[n];
			for (int i=0; i<n; ++i){
				array[i] = scanner.nextInt();
			}
			order(array);
			print(array);
		}
	}

	private static void order(int[] array) {
		// TODO Auto-generated method stub
		
		if (array == null || array.length <= 1){
			return;
		}
		
		int end = array.length - 1;
		int begin = 0;
		
		while (begin < end){
			
			//从前往后查找偶数
			while (begin < end && (array[begin]&1) == 1){
				
				++begin;
			}
			//从后往前查找奇数
			while (begin < end && (array[end]&1) == 0){
				
				--end;
			}
			
			if (begin < end){
				int temp = array[end];
				array[end] = array[begin];
				array[begin] = temp;
			}
		}
	}

	private static void endOrder (int[] array){
		if (array == null || array.length <= 0){
			throw new IllegalArgumentException("数组为null");
		}
		
		int n = array.length - 1;
		int index = n;
		for (int i=n; i>=0; ++i){
			
			//偶数
			if((array[i] & 1) == 0){
				array[index--] = array[i];
			}
			
		}
	}
	private static void print(int[] array) {
		// TODO Auto-generated method stub
		if (array == null || array.length <= 0){
			throw new IllegalArgumentException("数组为null");
		}
		
		int n = array.length;
		for (int i=0; i<n; ++i){
			
			if (i == n-1){
				System.out.print(array[i]);
			} else {
				System.out.print(array[i] + " ");
			}
		}
		System.out.println();
	}
	
	
}
