/**
 * 文件名：Main.java
 * 所在包：jobdu1081
 * 日期：2013-12-3 上午9:17:35
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1081;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：使用矩阵乘法结合快速幂等式进行求解
 * 其为  a1   0 1   a0
 *        =      *
 *     a2    q p   a1
 *     其中a2 = p*a0 + q*a1
 * 创建人：黄传聪
 * 创建时间：2013-12-3 上午9:17:35
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
	private static final int MOD = 10000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int p = scanner.nextInt();
			int q = scanner.nextInt();
			int k = scanner.nextInt();
			
			if(k == 0){
				System.out.println( a % MOD);
			}else if(k == 1){
				System.out.println( b % MOD);
			}else{
				
				Matrix source = new Matrix(a, 0, b, 0);
				Matrix result = new Matrix(0 , 1 , q , p);
				result = power(result , k);
				
				result = result.multiply(source) ;
				System.out.println(result.a00);
			}
			
			
		}
	}
	
	
	private static Matrix power(Matrix result, int k) {
		// TODO Auto-generated method stub
		Matrix E = new Matrix(1, 0 , 0 , 1 );//单位矩阵
		Matrix temp = new Matrix( );
		temp = result;
		while( k > 0){
			//奇数
			if((k & 1) == 1){
				E = E.multiply(temp);
			}
			
			temp = temp.multiply(temp);
			k >>= 1;
		}
		return E;
	}


	/**
	 *
	 * 项目名称：jobdu
	 * 类名称：Marrix
	 * 类描述：内部类，用于构建一个2*2矩阵
	 * 创建人：黄传聪
	 * 创建时间：2013-12-3 上午9:22:17
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	public static final class Matrix{
		
		public int a00,a01,a10,a11;

		public Matrix(int a00, int a01, int a10, int a11) {
			this.a00 = a00;
			this.a01 = a01;
			this.a10 = a10;
			this.a11 = a11;
		}
		
		public Matrix(){}
		
		public Matrix multiply(Matrix o){
			Matrix rev = new Matrix();
			rev.a00 = (a00 * o.a00 + a01 * o.a10) % MOD;
			rev.a01 = (a00 * o.a01 + a01 * o.a11) % MOD;
			rev.a10 = (a10 * o.a00 + a11 * o.a10) % MOD;
			rev.a11 = (a10 * o.a01 + a11 * o.a11) % MOD;
			return rev;
			
		}
		
	}

}
