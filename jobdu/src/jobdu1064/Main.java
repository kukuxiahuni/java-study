/**
 * 文件名：Main.java
 * 所在包：jobdu1064
 * 日期：2013-10-18 上午9:21:01
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1064;


public class Main {

	public static void main(String[] args){
		
		int n = 1000;
		while(n < 10000){
			if( n * 9 == reverse(n)){
				System.out.println(n);
			}
			n++;
		}
	}
	
	public static int reverse(int n){
		
		int a = n / 1000;
		int b = n % 1000 / 100;
		int c = n % 1000 % 100 / 10;
		int d = n % 1000 % 100 % 10;
		
		return d * 1000 + c * 100 + b * 10 + a;
	}
}
