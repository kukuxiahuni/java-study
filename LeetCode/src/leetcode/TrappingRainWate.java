/**
 * 文件名：TrappingRainWate.java
 * 所在包：leetcode
 * 日期：2014-11-3 下午10:49:43
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：TrappingRainWate
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-3 下午10:49:43
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class TrappingRainWate {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] A = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(A));
	}
	
	 public static int trap(int[] A) {
		 
		 if (A==null || A.length<=0){
			 return 0;
		 }
		 
		 int count = 0;
		 int len = A.length;
		 int[] left = new int[len];
		 int[] right = new int[len];
		 
		 //查找每个柱子的左侧和右侧的最大值
		 left[0] = 0;
		 right[len-1] = 0;
		 for (int i=1; i<len; ++i){
			 left[i] = Math.max(left[i-1], A[i-1]);
			 right[len-1-i] = Math.max(right[len-i], A[len-i]);
		 }
		 
//		 right[len-1] = 0;
//		 for (int i=len-2; i>=0; --i){
//			 right[i] = Math.max(right[i+1], A[i+1]);
//		 }
		 
		 for (int i=0; i<len; ++i){
			 int height = Math.min(left[i], right[i]);
			 if (height > A[i])
			 count += (height - A[i]);
		 }
		 
		 return count;
	 }

}
