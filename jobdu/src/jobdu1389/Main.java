/**
 * 文件名：Main.java
 * 所在包：jobdu1389
 * 日期：2014-10-9 上午11:21:58
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1389;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-9 上午11:21:58
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
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			long result = 1 << (n-1);
			System.out.println(result);
		}
	}

}
