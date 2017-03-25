/**
 * 文件名：Combinations.java
 * 所在包：leetcode
 * 日期：2014-9-16 下午4:52:37
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Combinations
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-9-16 下午4:52:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Combinations {

	   public List<List<Integer>> combine(int n, int k) {
	        
	        if (k>n) return null;
	        
	        List<List<Integer>> results = new ArrayList<>();
	        List<Integer> result = new ArrayList<>();
	        
	        get(n, k, 1, results, result);
	       
	        
	        for (List<Integer> list : results){
	        	
	        	for (Integer h : list){
	        		System.out.print(h);
	        	}
	        	
	        	System.out.println("*********************");
	        }
	        return results;
	    }
	   
	   private void get(int n, int k, int num, List<List<Integer>> results, List<Integer> result){
		   
		   if (result.size() >= k || num > n){
			   results.add(result);
			   result = new ArrayList<>();
			   return;
		   }
		   
		   result.add(num);
		   get(n, k, num+1, results, result);
		   
		   
	   }
	   
	   public static void main(String[] args) {
		Combinations c = new Combinations();
		c.combine(4, 2);
	}
}
