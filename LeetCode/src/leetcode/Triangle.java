/**
 * 文件名：Triangle.java
 * 所在包：leetcode
 * 日期：2014-10-7 上午10:03:35
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Triangle
 * 类描述：采用贪心算法
 * 创建人：黄传聪
 * 创建时间：2014-10-7 上午10:03:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Triangle {

	 public int minimumTotal(List<List<Integer>> triangle) {
		 if (triangle==null || triangle.size()<=0){
			 return 0;
		 }
		return getMin(triangle, 0, 0);
	 }
	
	
	/**
	 * 方法名称：count()
	 * 方法描述：
	 * @param level : 表示当前层  , index:表示上一个元素的位置，sum ： 临时值,此方法错误
	 * @return String    
	 * @Exception 
	 */
	private void count(List<List<Integer>> triangle, int level, int index, int sum){
		
		if (level == triangle.size()){
			return;
		}
		
		int len = triangle.get(level).size();
		if (index >= len){
			return;
		}
		if (index + 1 < len){
			
			int a = triangle.get(level).get(index), b = triangle.get(level).get(index  +1);
			if (a < b){
				count(triangle, level+1, index, sum+a);
			} else{
				count(triangle, level+1, index+1, sum+b);
			}
		} else{
			int a = triangle.get(level).get(index);
			count(triangle, level+1, index, sum+a);
		}
		
	}
	
	private int getMin(List<List<Integer>> triangle, int level, int index){
		
		if (level == triangle.size()){
			return 0;
		}
		int len = triangle.get(level).size();
		if (index >= len ){
			return 0;
		}
		
		int left = getMin(triangle, level+1, index), right = getMin(triangle, level+1, index+1) ;
		
		return (left < right ? left : right) + triangle.get(level).get(index);
	}
	
	/**
	 * 方法名称：getMinWithDP()
	 * 方法描述：测试通过
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private int getMinWithDP (List<List<Integer>> triangle){
		
		int m = triangle.size(), n = triangle.get(m-1).size();
//		int[][] dp = new int[m][n];
//		
		for (int i=m-2; i>=0; --i){
			for (int j=triangle.get(i).size()-1; j>=0; --j){
				int a = triangle.get(i).get(j);
				triangle.get(i).set(j, a +  min(triangle, i+1, j));
			}
		}
		
		return triangle.get(0).get(0);
	}
	
	
	private int min(List<List<Integer>> triangle, int i, int j) {
		// TODO Auto-generated method stub
		if (i >= triangle.size()){
			return 0;
		}
		
		int a = triangle.get(i).get(j), b = Integer.MAX_VALUE;
		
		if (j + 1 < triangle.get(i).size()){
			b = triangle.get(i).get(j+1);
		}
		return a < b ? a : b;
	}


	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Triangle triangle = new Triangle();
		List<List<Integer>> ngle = new ArrayList<>();
		List<Integer> l1 = Arrays.asList(2),
				l2 = Arrays.asList(3,4),
				l3 = Arrays.asList(6,5,7),
				l4 = Arrays.asList(4,1,8,3)		;
		ngle.add(l1);
		ngle.add(l2);
		ngle.add(l3);
		ngle.add(l4);
		
//		System.out.println(triangle.minimumTotal(ngle));
		System.out.println(triangle.getMinWithDP(ngle));
		
	}

}
