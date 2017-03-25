/**
 * 文件名：Main2.java
 * 所在包：jobdu1037
 * 日期：2013-11-18 下午1:33:39
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1037;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-11-18 下午1:33:39
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main2 {

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
			BigInteger a = scanner.nextBigInteger();
			BigInteger b = scanner.nextBigInteger();
			System.out.println(a.add(b));
			System.out.println(a.subtract(b));
			System.out.println(a.multiply(b));
		}
	}

}
