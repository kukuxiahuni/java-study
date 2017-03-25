/**
 * 文件名：Main.java
 * 所在包：jobdu1040
 * 日期：2013-11-17 上午11:51:03
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1040;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：输出第k个素数
 * 使用素数筛选法
 * 创建人：黄传聪
 * 创建时间：2013-11-17 上午11:51:03
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
	private static final int LEN = 200000;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]primes = new int[LEN];
		//使用素数筛选法求解素数
		//其中0表示是素数
		primes[0] = primes[1] = 0;
		int i,j;
		for(i=2;i<LEN;i++){//i*j表示i的j倍，也就是说能被i整除的数不是素数
			for(j=2;j<LEN&&i*j<LEN;j++){
				primes[i*j] = 1;//表示不是素数
			}
		}
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			int count  = 0;
			for(i =2;i<LEN;i++){
				if(primes[i] == 0){
					count++;
				}
				if(count == n){
					System.out.println(i);
					break;
				}
			}
		}
	}

}
