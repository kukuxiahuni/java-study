/**
 * 文件名：Main.java
 * 所在包：jobdu1516
 * 日期：2014-4-3 下午3:12:10
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1516;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-4-3 下午3:12:10
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			n = scanner.nextInt();
			int oIndex = 0;
			int eIndex = 0;
			//奇数
			int[] odds = new int[n];
			//偶数
			int[] evens = new int[n];
			for(int i=0;i<n;i++){
				int a = scanner.nextInt();
				if((a & 1) == 1){
					odds[oIndex++] = a;
				}else{
					evens[eIndex++] = a;
				}
			}
//			System.arraycopy(evens, 0, odds, oIndex, eIndex);
			for(int i=0;i<oIndex;i++){
				System.out.print(odds[i] + " ");
			}
			
			for(int i=0;i<eIndex-1;i++){
				System.out.print(evens[i] + " ");
			}
			System.out.println(evens[eIndex-1]);
			
			
		}
	}

}
