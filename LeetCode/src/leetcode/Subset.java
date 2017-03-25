/**
 * 文件名：Subset.java
 * 所在包：leetcode
 * 日期：2014-10-27 下午5:16:17
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Subset
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-27 下午5:16:17
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Subset {

	
	
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s = {1,2,2};
		List<List<Integer>> re = new ArrayList<>(subsets2(s));
		
		for (List<Integer> list : re){
			System.out.println(list.toString());
		}
	}

	
	 /**
	 * 方法名称：subsets()
	 * 方法描述： 采用位运算法
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static List<List<Integer>> subsets(int[] s) {
	     
		 if (s==null || s.length<= 0){
			 return null;
		 }
		 Arrays.sort(s);
		 int len = s.length;
		 int count = 1 << s.length;
		 List<List<Integer>> results = new ArrayList<>();
		 
		 for (int i=1; i<count; ++i){
			 List<Integer> list = new ArrayList<>();
			 for (int j=0; j<len; ++j){
//				 System.out.println(1<<j);
				 if ((i&(1<<j)) >= 1){
					 list.add(s[j]);
				 }
			 }
			 results.add(list);
		 }
		 List<Integer> list = new ArrayList<>();
		 results.add(list);
		 return results;
	 }
	 
	/**
	 * 方法名称：subsets1()
	 * 方法描述：采用组合的方式
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static List<List<Integer>> subsets1(int[] s){
		
		if (s==null || s.length<=0){
			return null;
		}
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int len=1; len<=s.length; ++len){
			combine(s, 0, len, list, results);
		}
		results.add(new ArrayList<Integer>());
		return results;
		
	}
	public static void combine(int[] s, int index, int len, List<Integer> list,  List<List<Integer>> results){
		
		if (index>=s.length && len>0){
			return;
		}
		
		if (len == 0){
			results.add(new ArrayList<>(list));
//			list = null;
//			list = new ArrayList<>();
			return;
		} 
		
		list.add(s[index]);
		combine(s, index+1, len-1, list, results);
		list.remove(Integer.valueOf(s[index]));
		combine(s, index+1, len, list, results);
		
	}
	
/**************************************************************************/
	/*
	 * subsetII中的内容
	 */
	public static Set<List<Integer>> subsets2(int[] s) {
	     
		 if (s==null || s.length<= 0){
			 return null;
		 }
		 Arrays.sort(s);
		 int len = s.length;
		 int count = 1 << s.length;
		 Set<List<Integer>> results = new HashSet<>();
		 
		 for (int i=1; i<count; ++i){
			 List<Integer> list = new ArrayList<>();
			 for (int j=0; j<len; ++j){
//				 System.out.println(1<<j);
				 if ((i&(1<<j)) >= 1){
					 list.add(s[j]);
				 }
			 }
			 results.add(list);
		 }
		 List<Integer> list = new ArrayList<>();
		 results.add(list);
		 return results;
	 }
}
