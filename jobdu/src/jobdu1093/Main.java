/**
 * 文件名：Main.java
 * 所在包：jobdu1093
 * 日期：2013-12-1 上午10:21:27
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1093;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-1 上午10:21:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {
	
	private static final String dic = "1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
	public static void main(String[] args){
		Scanner scanner = new Scanner (System.in);
		while(scanner.hasNext()){
			String str = scanner.nextLine();
			for(int i=0;i<str.length();i++){
				//在给定串中可以找到
				if(dic.indexOf(str.charAt(i))!= -1){
					System.out.print(dic.charAt(dic.indexOf(str.charAt(i))-1));
				}else{
					System.out.print(str.charAt(i));
				}
			}
			
			System.out.println();
		}
	}
}
