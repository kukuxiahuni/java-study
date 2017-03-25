/**
 * 文件名：Main.java
 * 所在包：jobdu1116
 * 日期：2013-12-16 上午10:57:47
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1116;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-16 上午10:57:47
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
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a = scanner.nextInt();
			String symbol = scanner.next();
			if("!".equals(symbol)){
				//求阶乘
				System.out.println(factorial(a));
			}else{
				int c = scanner.nextInt();
				operation(a,symbol,c);
			}
		}
	}

	private static void operation(int a, String symbol, int c) {
		// TODO Auto-generated method stub
		if("/".equals(symbol) ){
			if(c == 0){
				System.out.println("error"); 
			}else{
				System.out.println(a / c);
			}
		}else if( "%".equals(symbol)){
			if(c == 0){
				System.out.println("error"); 
			}else{
				System.out.println(a % c);
			}
		}else if("+".equals(symbol)){
			System.out.println(a + c);
		}else if("-".equals(symbol)){
			System.out.println(a - c);
		}else if("*".equals(symbol)){
			System.out.println(a * c);
		}
	}

	private static int factorial(int a) {
		// TODO Auto-generated method stub
		if(a==0 || a==1){
			return 1;
		}else{
			return a * factorial(a-1);
		}
	}

}
