/**
 * 文件名：Main.java
 * 所在包：jobdu1387
 * 日期：2014-3-18 上午9:13:47
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1387;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-18 上午9:13:47
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
			int n = scanner.nextInt();
			System.out.println(fib(n));
		}
	}

	private static long fib(int n) {
		// TODO Auto-generated method stub
		long result = 0;
		long pre = 0;
		long post = 1;
		if(n == 0){
			return pre;
		}
		if(n == 1){
			return post;
		}
		
		for(int i=2;i<=n;i++){
			result = pre + post;
			pre = post;
			post = result;
		}
		return result;
	}

}
