/**
 * 文件名：Main.java
 * 所在包：jobdu1515
 * 日期：2014-3-24 上午11:40:48
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1515;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-24 上午11:40:48
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n ;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			n = scanner.nextInt();
			if (n <= 0){
				break;
			}
			int[] results = new int[n];
			while (!increment(results)){
				print(results);
			}
			
//			for (int i=0; i<=9; ++i){
//				results[0] = i;
//				printByRecursion(results, n, 0);
//			}
		}
	}
	
	private static void print(int[] results) {
		// TODO Auto-generated method stub
		if (results == null || results.length <= 0){
			return;
		}
		
		int i = 0;
		int n = results.length;
		
		while (i<n && results[i] == 0){
			++i;
		}
		
		if (i < n){
			
			for (; i<n; ++i){
				System.out.print(results[i]);
			}
			
			System.out.println();
		}
		
		
		
	}

	/**
	 * 方法名称：increment()
	 * 方法描述：每次进行加1操作
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static boolean increment(int[] results){
		
		boolean flag = false;
		int n = results.length;
		int carry = 0;
		// array[0] = 9, 并且发生进位时退出
		for (int i=n-1; i>=0; --i){
			
			int temp = results[i] + carry;
			//只在第n-1位（最低位）发生加1操作
			if (i == n - 1){
				++temp;
			}
			
			carry = temp / 10;
			
			if (i ==0 && carry > 0){
				flag = !flag;
			} else {
				results[i] = temp % 10;
			}
			
			//没有进位，无须向前进行加
			if (carry <= 0){
				break;
			}
		}
		
		return flag;
	}
	
	private static void printByRecursion(int[] results, int length, int index){
		
		if (index == length - 1){
			print(results);
			return;
		}
		
		//修改第index+1 处 的位置值，值为【0-9】
		for (int i=0; i<=9; ++i){
			//此处无须恢复现场，都是在同一个位置进行修改
			results[index + 1] = i;
			printByRecursion(results, length, index + 1);
		}
	}

}
