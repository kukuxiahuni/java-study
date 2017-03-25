/**
 * 文件名：MaximumProductSubarray.java
 * 所在包：leetcode
 * 日期：2014-11-2 下午3:56:41
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：MaximumProductSubarray
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-2 下午3:56:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MaximumProductSubarray {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {-4,-3,-2};
		System.out.println(maxProduct(array));
	}
	
	/**
	 * 方法名称：maxProduct()
	 * 方法描述： 本题有三种情况：由于num[i]符号不定故其成绩可正可负， 故此我们需要保存上一个状态的最大最小值，并在获得当前的最大最小值后与当前值比较
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static int maxProduct(int[] A) {
        
		if (A==null || A.length<=0){
			return Integer.MIN_VALUE;
		}
		int max = A[0], curMax = A[0], curMin = A[0];
		int length = A.length;
		
		for (int i=1; i<length; ++i){
			
			int temp = curMin * A[i];
			
			curMin = Math.min(A[i], Math.min(temp, curMax * A[i]));
			curMax = Math.max(A[i], Math.max(temp, curMax * A[i]));
			
			max = Math.max(curMax, max);
			
		}
		
		return max;
    }

}
