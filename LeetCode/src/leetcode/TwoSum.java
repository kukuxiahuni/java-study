/**
 * 文件名：TwoSum.java
 * 所在包：leetcode
 * 日期：2014-9-4 下午10:18:23
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 项目名称：LeetCode
 * 类名称：TwoSum
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-9-4 下午10:18:23
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class TwoSum {

	 public int[] twoSum(int[] numbers, int target) {
	     
		 int[] results = new int[2];
		 
		 Map<Integer, Integer> map = new HashMap<>(numbers.length);
		 
		 for (int i=0; i<numbers.length; ++i){
			 
			 map.put(numbers[i], i);
		 }
		 
		 for (int i=0; i<numbers.length; ++i ){
			 
			 int temp = target - numbers[i];
			 
			 if (map.containsKey(temp) && map.get(temp) > i){
				 
				 results[0] = Math.min(i+1, map.get(temp) + 1);
				 results[1] = Math.max(i+1, map.get(temp) + 1);
				 break;
			 }
		 }
		 
		 return results;
	 }
}
