/**
 * 文件名：Main.java
 * 所在包：jobdu1132
 * 日期：2013-12-17 上午11:11:07
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1132;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-17 上午11:11:07
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
			
			int i;
			int sum = 0;
			for(i=1;i<=n;i++){
				
				if( hasNoRelative(i)){
					sum += i * i;
				}
			}
			
			System.out.println(sum);
			
		}
	}

	private static boolean hasNoRelative(int n) {
		// TODO Auto-generated method stub
		if( n % 7 != 0){
			int i;
			while(n > 0){
				if(n % 10 == 7){
					return false;
				}
				
				n /= 10;
			}
			return true;
		}
		return false;
	}

}
