/**
 * 文件名：Main.java
 * 所在包：jobdu1084
 * 日期：2013-11-27 下午3:08:07
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1084;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 
 * 九度-1084 整数拆分：一个整数总可以拆分为2的幂的和
   	思路：1.对于奇数拆分，奇数的拆分数和比他小1的偶数的拆分数相同   
          2. 偶数拆分：分为两种情况，1. 拆分的数据，全部是偶数，此时最小的值为2，其拆分数和m/2的一样；2.拆分的数
			   据中包含1，其拆分过程数和比他小1的奇数的一样.
	使用数组方式，不使用递归
 * 创建人：黄传聪
 * 创建时间：2013-11-27 下午3:08:07
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
	private static final int MODE = 1000000000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int[] result = new int[n+1];
			result[0] = result[1] = 1;
			for(int i=2;i<=n;i++){
				if((i&1) == 1){
					result[i] = result[i-1];
				}else{
					result[i] = (result[i-1] + result[i / 2]) % MODE;
				}
			}
			
			System.out.println(result[n]);
			
		}
		
	}

}
