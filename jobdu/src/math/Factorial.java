/**
 * 文件名：Factorial.java
 * 所在包：math
 * 日期：2014-4-2 下午4:51:20
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
 * 类名称：Factorial
 * 类描述：因子和阶乘
 * 
 * 输入正整数n（2<=n<=100），
 * 把阶乘n!=1*2*3*...*n分解成素因子相乘的形式，
 * 从小到大输出各个素数（2、3、5...）的指数。
 * 例如，5! 表示为 3，1， 1个2， 3， 5。
 * 其中 5!= 1*2*3*4*5 而素数为：2,3,5各一个，然而4 = 2*2，故有3个2.最终结果为：3 1 1
 * 程序忽略比最大素因子更大的素数（否则末尾会有无穷多个0）。
 * 
 * 解析：
 * 创建人：黄传聪
 * 创建时间：2014-4-2 下午4:51:20
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Factorial {

	/** 设定素数数组的最大长度   */    
	private static final int MAXLEN = 100;
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//素数数组
		int[] primes = new int[MAXLEN];
		
		int index = 0;
		for(int i=2;i<=MAXLEN;i++){
			if(isPrime(i)){
				primes[index++] = i;
			}
		}
		int n, max ;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			//素数数组中素数的个数
			int[] counts = new int[MAXLEN];
			max = 0;
			n = scanner.nextInt();
			//判断n!的各个因子是否是素数
			for(int i=2;i<=n;i++){
				int m = i;
				for(int j=0;j<index;j++){
					//循环判断i由几个该素数的乘积组成
					while(m % primes[j] == 0 ){
						counts[j]++;
						m /= primes[j];
						
						if(j > max){
							max = j;
						}
					}
				}
			}
			
			for(int i=0;i<=max;i++){
				System.out.print(counts[i] + " ");
			}
			
			System.out.println();
		}

	}
	/**
	 * 方法名称：isPrime()
	 * 方法描述：判断是否是素数
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static boolean isPrime(int n) {
		// TODO Auto-generated method stub
		
		if(n == 1){
			return false;
		}
		
		for(int i=2;i*i <= n;i++){
			if(n % i == 0){
				return false;
			}
		}
		return true;
	}
	
	

}
