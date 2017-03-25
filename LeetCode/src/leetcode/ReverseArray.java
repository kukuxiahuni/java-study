/**
 * 文件名：ReverseArray.java
 * 所在包：leetcode
 * 日期：2014-9-17 下午9:44:01
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
 * 类名称：ReverseArray
 * 类描述： 数组倒转
 * 创建人：黄传聪
 * 创建时间：2014-9-17 下午9:44:01
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ReverseArray {

	protected void reverse(int[] array){
		
		if (null == array || array.length <= 1){
			return;
		}
		
		int begin = 0;
		int end = array.length - 1;
		
		while (begin < end){
			
			int temp = array[begin];
			array[begin] = array[end];
			array[end] = temp;
			
			++begin;
			--end;
		}
		
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void main(String[] args) {
		ReverseArray test = new ReverseArray();
		
		int[] array = {1,2,3,4};
		test.reverse(array);
	}
}
