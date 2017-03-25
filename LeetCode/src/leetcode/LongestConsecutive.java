/**
 * 文件名：LongestConsecutive.java
 * 所在包：leetcode
 * 日期：2014-9-4 下午10:03:07
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.HashSet;

/**
 *
 * 项目名称：LeetCode
 * 类名称：LongestConsecutive
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-9-4 下午10:03:07
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class LongestConsecutive {

	public int longestConsecutive(int[] num) {
        
		int result = 0;
		
		HashSet<Integer> set = new HashSet<>(num.length);
		
		for (int i=0; i<num.length; ++i){
			
			set.add(num[i]);
		}
		
		for (int i=0; i<num.length; ++i){
			
			if (set.contains(num[i])){
				
				int count = 1;
				set.remove(num[i]);
				//左右寻找
				int next = num[i] - 1;
				
				while (set.contains(next)){
					++count;
					set.remove(next);
					next -= 1;
				}
				
				next = num[i] + 1;
				while (set.contains(next)){
					++count;
					set.remove(next);
					next += 1;
				}
				result = Math.max(result, count);
				
			}
		}
		
		return result;
    }
}
