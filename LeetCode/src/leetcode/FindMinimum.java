/**
 * 文件名：FindMinimum.java
 * 所在包：leetcode
 * 日期：2014-10-31 下午9:07:02
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：FindMinimum
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-31 下午9:07:02
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class FindMinimum {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {0,1,1,2,2,4,5,6,7};
		System.out.println(findMinWithDuplicate(array));
	}
	
	/**
	 * 方法名称：findMin()
	 * 方法描述：剑指offer有讲解
	 * 1. 数组未旋转，则只需返回第一个元素
	 * 2. 数组旋转，数组中没有重复数字，则数组前半部分元素 >= 后半部分元素；
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static int findMin(int[] num) {
        
		if (num==null || num.length<=0){
			return -1;
		}
		
		if (num.length == 1){
			return num[0];
		}
		//begin指针永远指向前半部分，end指针永远指向后半部分
		//最小值位于 前半部分与后半部分交接处。
		//end - begin = 1时，结束；也就是end位于后半部分最前，begin位于前半部分最后
		int begin = 0, end = num.length - 1, mid = 0;
		
		while (num[begin] >= num[end] ){
			mid = begin + ((end - begin) >> 1);
			if (num[mid] >= num[begin]){
				begin = mid;
			} else if (num[mid] <= num[end]){
				end = mid;
			}
			
			if (end - begin == 1){
				mid = end;
				break;
			}
		}
		return num[mid];
    }
	
	private static int findMinWithDuplicate(int[] num){
		
		if (num==null || num.length<=0){
			return -1;
		}
		
		//采用二分查找查询
		int begin = 0, end = num.length - 1, mid = begin;
		
		while (num[begin] >= num[end]){
			
			if (end - begin == 1){
				mid = end;
				break;
			}
			mid = begin + ((end - begin) >>1);
			
			//无法判断最小值的区域，只能从头遍历
			if (num[mid] == num[begin] && num[mid] == num[end]){
				
				int min = num[begin];
				for (int i=begin+1; i<=end; ++i){
					min = min < num[i] ? min : num[i];
				}
				
				return min;
			}
			
			//前半部分数组
			if (num[mid] >= num[begin]){
				begin = mid;
			} else if(num[mid] <= num[end]){
				end = mid;
			}
		}
		
		return num[mid];
	}

}
