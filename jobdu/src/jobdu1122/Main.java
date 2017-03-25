/**
 * 文件名：Main.java
 * 所在包：jobdu1122
 * 日期：2013-12-16 上午11:16:44
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1122;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-16 上午11:16:44
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n == 0){
				break;
			}
			
			System.out.println(recursion(n));
			
		}
	}

	private static int recursion(int n) {
		// TODO Auto-generated method stub
		if(n == 1){
			return 1;
		}
		if(n == 2){
			return 2;
		}
		return recursion(n-1) + recursion(n-2);
	}
}
