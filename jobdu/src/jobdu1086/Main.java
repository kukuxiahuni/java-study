/**
 * 文件名：Main.java
 * 所在包：jobdu1086
 * 日期：2013-12-8 上午10:31:31
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1086;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：未写完
 * ，出错了
 * 
 * 创建人：黄传聪
 * 创建时间：2013-12-8 上午10:31:31
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args){
		Scanner scanner = new Scanner (System.in);
		while(scanner.hasNext()){
			long l1 = scanner.nextLong();
			long l2 = scanner.nextLong();
			long l3 = scanner.nextLong();
			
			long c1 = scanner.nextLong();
			long c2 = scanner.nextLong();
			long c3 = scanner.nextLong();
			//起始 车站
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			//a和b之间的车站数目
			int n = scanner.nextInt();
			int i ;
			
			long count = 0;
			if(n != 0){
				long[] distances = new long[n+1];
				i = 2;
				distances[1] = 0;
				while (n > 0){
					distances[i++] = scanner.nextLong();
					n--;
				}
				
				count = distances[b] - distances[a];//a站到b站的距离
				//判断其距离的和是否是大于l3
				if(count > l3){
					
				}else{
					if(count > l1){
						System.out.println(c2);
					}else{
						System.out.println(c1);
					}
				}
			}
		}
	}
}
