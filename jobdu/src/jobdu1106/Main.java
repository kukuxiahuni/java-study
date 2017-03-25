/**
 * 文件名：Main.java
 * 所在包：jobdu1106
 * 日期：2013-12-13 上午11:19:57
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1106;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-13 上午11:19:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n == 0){
				break;
			}
			System.out.println(count(n) + " " + count(n * n));
		}
	}

	private static int count(int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(n > 0){
			sum += n % 10;
			n = n / 10;
		}
		return sum;
	}
}
