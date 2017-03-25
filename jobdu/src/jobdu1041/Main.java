/**
 * 文件名：Main.java
 * 所在包：jobdu1041
 * 日期：2013-11-17 上午10:41:43
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package jobdu1041;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：给定一串数字，按照升序排序，并去掉重复数字后输出
 * 创建人：黄传聪
 * 创建时间：2013-11-17 上午10:41:43
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
			int n = scanner.nextInt();
			if(n == 0){
				break;
			}
			int[] nums = new int[n];
			
			int i;
			for(i=0;i<n;i++){
				nums[i] = scanner.nextInt();
			}
			
			//排序
			Arrays.sort(nums);
			//输出
			int[] temp = new int[n];
			int k = 0;
			temp[k] = nums[0];
			for(i=1;i<n;i++){
				if(nums[i] == nums[i-1]){
					continue;
				}else{
					k++;
					temp[k] = nums[i];
				}
			}

			for(i=0;i<k;i++){
				System.out.print(temp[i] + " ");
			}
			System.out.print(temp[k]);
		}
	}

}
