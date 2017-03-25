/**
 * 文件名：SearchForRange.java
 * 所在包：leetcode
 * 日期：2014-10-31 下午8:06:48
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
 * 类名称：SearchForRange
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-31 下午8:06:48
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SearchForRange {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {5, 7, 7, 8, 8, 10};
//		System.out.println(getBegin(array, 5, 0, 0));
//		System.out.println(getEnd(array, 5, 0, 0));
		int[] re = getIndex(array, 7, 0, 5);
		System.out.println(Arrays.toString(re));
	}
	
	/**
	 * 方法名称：getBegin()
	 * 方法描述：获得target的第一个位置
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int getBegin(int[] array, int target, int begin, int end){
		
		if (array==null || array.length<=0 || begin>end || end>=array.length){
			return -1;
		}
		
		while (begin <= end){
			
			int mid = begin + ((end - begin) >> 1);
			
			if (array[mid] == target){
				
				if (mid==0 || (mid-1>=0 && array[mid-1]!=array[mid])){
					return mid;
				} else {
					end = mid - 1;
				}
			} else if (array[mid] > target){
				end = mid - 1;
				
			} else {
				begin = mid + 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 方法名称：getEnd()
	 * 方法描述：获取target的最后位置
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int getEnd (int[] array, int target, int begin, int end){
		
		if (array==null || array.length<=0 || begin>end || end>=array.length){
			return -1;
		}
		
		while (begin <= end){
			
			int mid = begin + ((end - begin) >> 1);
			
			if (array[mid] == target){
				
				if (mid==end || (mid+1<=end && array[mid+1]!=array[mid])){
					return mid;
				} else {
					begin = mid + 1;
				}
			} else if (array[mid] > target){
				end = mid - 1;
				
			} else {
				begin = mid + 1;
			}
		}
		
		return -1;
	}
	
	/**
	 * 方法名称：getIndex()
	 * 方法描述：使用二分查找，最差时间复杂度为o(n),建议使用上面的方式
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int[] getIndex (int[] array, int target, int begin, int end){
		
		if (array==null || array.length<=0 || begin>end || end>=array.length){
			return null;
		}
		int[] results = {-1, -1};
		while (begin <= end){
			int mid = begin + ((end - begin) >> 1);
			
			if (array[mid] == target){
				int beginIndex = mid, endIndex = mid;

				while (beginIndex-1>=0 && array[beginIndex-1] == target){
					--beginIndex;
				}
				results[0] = beginIndex;
				
				while (endIndex+1<=end && array[endIndex+1] == target){
					++endIndex;
				}
				results[1] = endIndex;
				
				return results;
				
			} else if (array[mid] < target){
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		
		return results;
		
	}

}
