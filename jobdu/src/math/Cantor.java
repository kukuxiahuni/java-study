/**
 * 文件名：Cantor.java
 * 所在包：math
 * 日期：2014-4-2 下午4:38:29
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package math;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Cantor
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-4-2 下午4:38:29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Cantor {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			n = scanner.nextInt();
			int k = 1;
			int s = 0;
			while(true){
				s += k;
				if(n <= s){
					//确定n在第k条线上
					//判断第k条线是不是奇数条
					if((k&1) == 1){
						System.out.println((s-n+1) + "/" + (k-s+n));
					}else{
						System.out.println((k-s+n) + "/" + (s-n+1));
						
					}
					
					break;
				}
				k++;
			}
			
			solve(n);
		}

	}
	
	private static void solve(int n){
		
		int k = (int)Math.ceil(((Math.sqrt(8*n+1)-1)/2) - 1e-9);
		int s = k * (k + 1) / 2;
		if((k & 1) == 1){
			System.out.println((s-n+1) + "/" + (k-s+n));
		}else{
			System.out.println((k-s+n) + "/" + (s-n+1));
			
		}
	}

}
