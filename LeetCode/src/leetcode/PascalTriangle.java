/**
 * 文件名：Triangle.java
 * 所在包：leetcode
 * 日期：2014-10-5 下午9:45:34
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Triangle
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-5 下午9:45:34
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class PascalTriangle {
	
	  private List<List<Integer>> results = new ArrayList<>();
	  
	  public PascalTriangle() {

		  List<Integer> zero = new ArrayList<>();
		  zero.add(1);
		  results.add(zero);
		  
		  List<Integer> one = new ArrayList<>();
		  one.add(1);
		  one.add(1);
		  results.add(one);
	  }
	  public List<Integer> getRow(int rowIndex) {
	        
		if (rowIndex < results.size() && results.get(rowIndex) != null){
			return results.get(rowIndex);
		} else {
			//计算并保存结果
			List<Integer> temp = get(rowIndex);
			results.add(temp);
			return results.get(rowIndex);
		}
		
		
	  }
	private List<Integer> get(int rowIndex) {
		// TODO Auto-generated method stub
		
		List<Integer> pre = getRow(rowIndex - 1);
		List<Integer> cur = new ArrayList<Integer>();
		
		cur.add(1);
		for (int i=1; i<rowIndex; ++i){
			cur.add(pre.get(i) + pre.get(i-1));
		}
		cur.add(1);
		return cur;
	}
	
	public List<Integer> getRowSimple(int rowIndex) {
		 
		Integer[] arr = new Integer[rowIndex + 1];
		arr[0] = 1;
		for (int i=1; i<=rowIndex; ++i){
			for (int j=i; j>0; --j){
				if (j == i){
					arr[j] = 1;
				} else {
					arr[j] = arr[j-1] + arr[j];
				}
			}
		}
		
		return Arrays.asList(arr);
	}
	public static void main(String[] args) {
		PascalTriangle triangle = new PascalTriangle();
		
		System.out.println(triangle.getRow(3).toString());
		System.out.println(triangle.getRow(2).toString());
		System.out.println(triangle.getRow(4).toString());
		
		System.out.println(triangle.getRowSimple(3).toString());
	}
}
