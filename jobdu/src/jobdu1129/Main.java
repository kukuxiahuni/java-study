/**
 * 文件名：Main.java
 * 所在包：jobdu1129
 * 日期：2013-12-17 上午11:01:48
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1129;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-17 上午11:01:48
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str = scanner.next();
			
			if(str==null || "0".equals(str)){
				break;
			}
			
			int sum = 0;
			int i;
			for(i=0;i<str.length();i++){
				sum += (str.charAt(i)-'0') * (Math.pow(2, str.length()-i) - 1);
			}
			
			System.out.println(sum);
		}
		
	}
}
