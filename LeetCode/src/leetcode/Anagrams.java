/**
 * 文件名：Anagrams.java
 * 所在包：leetcode
 * 日期：2014-10-28 下午5:42:10
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Anagrams 参考：http://blog.csdn.net/doc_sgl/article/details/12314555
 * 类描述：Anagram（回文构词法）是指由颠倒字母顺序组成的单词，比如“dormitory”颠倒字母顺序会变成“dirty room”，“tea”会变成“eat”。
 * 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。
 * 1. 对单词进行排序： 如bca->abc, 查询缓存空间（HashMap<K,V>, k为排序后的字符串，v为k排序之前在数组中的下标）
 * 2. 查询缓存空间，如果空间中存在，（1）如果缓存空间中的字符串未存入结果集，则将当前字符串和缓存空间的字符串的原串存入结果集，并修改缓存空间的标记；（2）否则，仅存入当前字符串的原串。
 * 3. 如果空间中不存在，则将字符串及其下标存入缓存空间中。
 * 创建人：黄传聪
 * 创建时间：2014-10-28 下午5:42:10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Anagrams {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"abc", "bca", "bac", "bbb", "bbca", "abcb"};
		System.out.println(anagrams(strs));
	}
	
	public static List<String> anagrams(String[] strs) {
        
		if (strs==null || strs.length<=0){
			return null;
		}
		
		List<String> results = new ArrayList<String>();
		//其中key为排序后的字段，value为key在字符串数组中的下标
		Map<String, Integer> temp = new HashMap<>();
		for (int i=0; i<strs.length; ++i){
			
			char[] chs = strs[i].toCharArray();
			Arrays.sort(chs);
			String str = String.valueOf(chs);
			
			if (temp.containsKey(str) ){
				if ( temp.get(str) != -1){
					
					//如果temp中存在，并且未被放入结果集中，放入
					results.add(strs[temp.get(str)]);
					//放入当前元素
					results.add(strs[i]);
					//标志，防止被重复放入结果集
					temp.put(str, -1);
					
				} else{
					results.add(strs[i]);
				}
			} else{
				temp.put(str, i);
			}
		}
		
		temp = null;
		return results;
    }

}
