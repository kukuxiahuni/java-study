/**
 * 文件名：SumClosest3.java
 * 所在包：leetcode
 * 日期：2014-10-28 上午11:15:07
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：SumClosest3
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-28 上午11:15:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SumClosest3 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] num = {-1,2,1,-4};
		System.out.println(threeSumClosest(num, 1));
	}
	
	public static int threeSumClosest(int[] num, int target) {
       
		int min = Integer.MAX_VALUE;
		int result = 0;
		if (num==null || num.length<=2){
			return min;
		}
		Arrays.sort(num);
		int a=0, b=0, c=0;
		int len = num.length;
		for (int i=0; i<len-2; ++i){
			a = num[i];
			int k = i+1, j = len-1;
			while (k < j){
				b = num[k];
				c = num[j];
				int sum = a + b + c;
//				System.out.println(Math.abs(target-sum));
				if (min > Math.abs(target-sum)){
					min = Math.abs(target-sum);
					result = sum;
				}
				if (sum < target){
					++k;
				} else{
					--j;
				}
			}
		}
		return result;
    }

}
