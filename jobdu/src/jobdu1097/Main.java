/**
 * 文件名：Main.java
 * 所在包：jobdu1097
 * 日期：2013-12-1 上午11:16:36
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1097;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2013-12-1 上午11:16:36
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
		//数组必须提到上面吗？
		int[] array1 = new int[100000];
		int[] array2 = new int[100000];
		int[] result = new int[100000];
		while(scanner.hasNext()){
			int n = scanner.nextInt();
			if(n ==0 )break;
			int i,j;
			for(i=0;i<n;i++){
				int n1 = scanner.nextInt();
				int n2 = scanner.nextInt();
				
				for(j=0;j<n1;j++){
					array1[j] = scanner.nextInt();
				}
				for(j=0;j<n2;j++){
					array2[j] = scanner.nextInt();
				}
				
				int b1 = scanner.nextInt()-1;
				int e1 = scanner.nextInt()-1;
				int b2 = scanner.nextInt()-1;
				int e2 = scanner.nextInt()-1;
				
				int m = 0;
				
				for(j=b1;j<=e1;j++){
					result[m++] = array1[j];
				}
				for(j=b2;j<=e2;j++){
					result[m++] = array2[j];
				}
				
				System.out.println(result[(m-1)/2]);
				
			}
		}
	}

}
