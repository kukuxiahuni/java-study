/**
 * 文件名：RotatedArray.java
 * 所在包：leetcode
 * 日期：2014-8-30 下午9:59:21
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：RotatedArray
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-30 下午9:59:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RotatedArray {

	/**
	 * 有序数组的查找直接使用二分查找很方便，所以旋转之后的数组要利用二分搜索的原理需要判断哪一部分仍然是有序的，然后确定在哪一部分继续搜索。具体判断方法如下：

		（1）如果target==A[mid]，那么mid就是我们要的结果，直接返回；

		（2）如果A[begin]<=A[mid]，那么说明从begin到mid一定是有序的，同样只需要判断target是否在这个范围内，如果是则把右边缘移到mid-1，
			否则就target在另一半，即把左边缘移到mid+1。

		（3）如果A[begin]>A[mid]，那么说明从mid到last一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在mid到last之间，
			如果是则把左边缘移到mid+1，否则就target在另一半，即把右边缘移到mid-1。
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	  public int search(int[] A, int target) {
	        int start = 0;
	        int end = A.length - 1;
	        while(start <= end){
	        	int mid = (start + end) / 2;
	            if (A[mid] == target) return mid;
	            if (A[start] <= A[mid]) {
	                // situation 1, red line
	                if (A[start] <= target && target <= A[mid]) {
	                    end = mid-1;
	                }
	                else {
	                    start = mid+1;
	                }
	            }
	            else {
	                // situation 2, green line
	                if (A[mid] <= target && target <= A[end]) {
	                    start = mid+1;
	                }
	                else {
	                    end = mid-1;
	                }
	            }
	        	
	        }
	        
	        
	        return -1;
	    }
	  
	  public int searchII(int[] A, int target) {
	        int start = 0;
	        int end = A.length - 1;
	        while(start <= end){
	        	int mid = (start + end) / 2;
	            if (A[mid] == target) return mid;
	            if (A[start] < A[mid]) {
	                // situation 1, red line
	                if (A[start] <= target && target <= A[mid]) {
	                    end = mid-1;
	                }
	                else {
	                    start = mid+1;
	                }
	            }
	            else if(A[start] > A[end]){
	                // situation 2, green line
	                if (A[mid] <= target && target <= A[end]) {
	                    start = mid+1;
	                }
	                else {
	                    end = mid-1;
	                }
	            }else {
	            	++start;
	            	
	            }
	        	
	        }
	        
	        
	        return -1;
	    }
}
