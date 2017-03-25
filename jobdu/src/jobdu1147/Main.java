/**
 * 文件名：Main.java
 * 所在包：jobdu1047
 * 日期：2013-12-11 下午9:09:32
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1147;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：ax + by = n ;必定有解
 * 思路：http://poj.org/showmessage?message_id=54159
 * 创建人：黄传聪
 * 创建时间：2013-12-11 下午9:09:32
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	public static void main(String[] args){
		
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int ca = scanner.nextInt();
			int cb = scanner.nextInt();
			int n = scanner.nextInt();
			
			if(n == cb){
				System.out.println("fill B");
				System.out.println("success");
			}else{
				//查找两组解
				//两组解（a1，b1）及（a2，b2），
				//其中a1 >0，b1<0；a1是满足方程的最小正整数；a2<0，b2>0，a2是满足条件的最大负整数；
				int a1 = 1, b1 = 0;
				int a2 = -1, b2 = 0;
				
				//搜索第一组解,寻找a1最小的解
				
				for(;a1 * ca + b1 * cb != n;a1++){
					for(;a1 * ca + b1 * cb > n;b1--){
						if(a1 * ca + b1 * cb == n){
							break;
						}
					}
				}
				//搜索第二组解
				for(;a2 * ca + b2 * cb != n;a2--){
					for(;a2 * ca + b2 * cb < n;b2++){
						if(a2 * ca + b2 * cb == n){
							break;
						}
					}
				}
				//采用第一组解
				//fill A a1次，每次fill A后,pour到B，如果B满则empty B,再将A中剩下的pour到B，这样empty B |b1|次以后
				if(Math.abs(a1) + Math.abs(b1) < Math.abs(a2) + Math.abs(b2) - 1){
					a1 = Math.abs(a1);
					b1 = Math.abs(b1);
					int tempA = ca;
					int tempB = cb;
					while(a1 > 0 ){
						System.out.println("fill A");
						a1--;
						System.out.println("pour A B");
						tempB -= tempA;
						//如果b满
						if(tempB< 0 && b1 > 0){
							System.out.println("empty B");
							b1--;
							//将a中剩余的导入b中
							System.out.println("pour A B");
						}
					}
					System.out.println("success");
				}else{
					a2 = Math.abs(a2) - 1;
					b2 = Math.abs(b2);
					int tempA = ca;
					int tempB = cb;
					while(b2 > 0 ){
						System.out.println("fill B");
						b2--;
						System.out.println("pour B A");
						tempA -= tempB;
						//如果a满
						if(tempA< 0 && a2 > 0){
							System.out.println("empty A");
							a2--;
							//将a中剩余的导入b中
							System.out.println("pour B A");
						}
					}
					System.out.println("success");
					
				}
			}
		}
	}
}
