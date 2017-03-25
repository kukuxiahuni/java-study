/**
 * 文件名：Main.java
 * 所在包：jobdu1085
 * 日期：2013-11-28 上午9:20:16
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1085;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：本方法用于x,y值较小的情况下，较大的情况下，还需要使用快速幂取模算法
 * 创建人：黄传聪
 * 创建时间：2013-11-28 上午9:20:16
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int k = scanner.nextInt();
			
			long result = root(x,y,k);
			System.out.println(result);
			
		}
	}

	private static long root(int x, int y, int k) {
		// TODO Auto-generated method stub
		
		long temp = (long) Math.pow(x, y);
		while(temp > k){
			//求temp的各个位的和
			temp = sum(temp);
		}
		return temp;
	}

	private static long sum(long temp) {
		// TODO Auto-generated method stub
		int sum = 0;
		while(temp > 0){
			sum += temp % 10;
			temp = temp / 10;
		}
		return sum;
	}
}
