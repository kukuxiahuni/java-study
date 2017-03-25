/**
 * 文件名：Main.java
 * 所在包：jobdu1042
 * 日期：2013-10-20 上午10:49:45
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1042;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：1. 本题用于求解字符串的最大公共子序列问题。
 * 		   2. 本题的解符合最优子结构，故采用动态规划
 *         3. 
 * 创建人：黄传聪
 * 创建时间：2013-10-20 上午10:49:45
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

		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String str1 = scanner.next();
			String str2 = scanner.next();
			
			int a = str1.length();
			int b = str2.length();
			//采用备忘录方法的动态规划
			//存储最大子串的 长度
			//（i，j）存放的是Xi与Yj的最大公共子串的长短
			int[][] maxLength = new int[a+1][b+1];
			int i , j;
			for(i=1;i<=b;i++){
				maxLength[0][i] = 0;
			}
			for(i=1;i<=a;i++){
				maxLength[i][0] = 0;
			}
			for(i=1;i<=a;i++){
				for(j=1;j<=b;j++){
					if(str1.charAt(i-1) == str2.charAt(j-1)){
						maxLength[i][j] = maxLength[i-1][j-1] + 1;
					}else{
						maxLength[i][j]= maxLength[i-1][j]>maxLength[i][j-1]?maxLength[i-1][j] : maxLength[i][j-1];
					}
				}
				
			}
			
			System.out.println(maxLength[a][b]);
			
		}
		
	}

}
