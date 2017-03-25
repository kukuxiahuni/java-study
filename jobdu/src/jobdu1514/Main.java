/**
 * 文件名：Main.java
 * 所在包：jobdu1514
 * 日期：2014-10-13 上午8:55:04
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1514;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-13 上午8:55:04
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	
	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			
			for (int i=0; i<n; ++i){
				double base = scanner.nextDouble();
				int exponnet = scanner.nextInt();
				
				if (base == 0){
					System.out.println("INF");
				} else{
					
					boolean flag = false;
					if (exponnet < 0){
						flag = !flag;
						exponnet = -exponnet;
					}
					double result = pow (base, exponnet);
					
					DecimalFormat  format = new DecimalFormat("0.00E00f");
					
					if (flag){
						System.out.println(format.format(1.00 / result));
					} else {
						System.out.println(format.format(result));
					}
					
				}
				
			}
		}
	}

	private static double pow(double base, int exponnet) {
		// TODO Auto-generated method stub
		
		if (exponnet == 0){
			return 1.00;
		} else if (exponnet == 1){
			return base;
		} else if (exponnet == 2){
			return base * base;
		}
		
		double mid = pow (base, exponnet >> 1);
		
		if ((exponnet & 1 ) == 0){
			return mid * mid;
		}
		
		return mid * mid * base;
	}
	
	
}
