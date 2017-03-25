/**
 * 文件名：Main.java
 * 所在包：jobdu1030
 * 日期：2013-10-17 下午10:37:55
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1063;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-10-17 下午10:37:55
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
			int result = 0;
			result = n<0 ? (-3) * n * (n-1) / 2 :  3 * n * (n+1) / 2;
			System.out.println(result);
		}
	}
}
