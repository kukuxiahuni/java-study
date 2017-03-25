/**
 * 文件名：CombinationSum.java
 * 所在包：leetcode
 * 日期：2014-11-2 上午10:42:40
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
 * 类名称：CombinationSum
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-2 上午10:42:40
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
/**
 *
 * 项目名称：LeetCode
 * 类名称：CombinationSum
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-2 上午11:57:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
/**
 *
 * 项目名称：LeetCode
 * 类名称：CombinationSum
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-2 上午11:57:30
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class CombinationSum {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {10,1,2,7,6,1,5};
		combinationSum(array, 8);
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
	     
		if (candidates==null || candidates.length<=0){
			return null;
		}
		Arrays.sort(candidates);
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> tempResult = new ArrayList<>();
		
		dfsWithoutDuplicate (candidates, target, tempResult, results, 0);
		
		for (List<Integer> te : results){
			System.out.println(te);
		}
		return results;
		
		
		
	}
	
	/**
	 * 方法名称：dfs()
	 * 方法描述：
	 * @param  index : 表示array数组中的第几个元素
	 * @return String    
	 * @Exception 
	 */
	private static void dfs (int[] array, int target, List<Integer> tempResult, List<List<Integer>> results, int index){
		
		if (target == 0){
			results.add(new ArrayList<>(tempResult));
			return;
		}
		
		for (int i=index; i<array.length; ++i){
			if (target < array[i]) return; //剪枝
			
			tempResult.add(array[i]);
			dfs (array, target-array[i], tempResult, results, i);//因为允许重复，故可以重复设置i
			tempResult.remove(Integer.valueOf(array[i]));
		}
		
	}
	
	/**
	 * 方法名称：dfsWithoutDuplicate()
	 * 方法描述：保证数组中每一个元素只能使用一次
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void dfsWithoutDuplicate(int[] array, int target, List<Integer> tempResult, List<List<Integer>> results, int index){
		
		if (target == 0){
			results.add(new ArrayList<>(tempResult));
			return;
		}
		
		int pre = -1;
		
		for (int i=index; i<array.length; ++i){
			//如果该元素已经使用过
			if (pre == array[i]){
				continue;
			}
			
			if (target < array[i]){
				return;
			}
			
			pre = array[i];
			tempResult.add(array[i]);
			dfs (array, target-array[i], tempResult, results, i+1);//因为不允许重复，故不可以重复设置i
			tempResult.remove(Integer.valueOf(array[i]));
		}
	}
	
	/**
	 * 方法名称：partition()
	 * 方法描述：使用target进行一次划分
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private int partition(int[] array, int target){
		
		int begin = 0, end = array.length;
		
		int index = begin - 1;
		for (int i=begin; i<end; ++i){
			
			if (array[i] <= target){
				++index;
				if (i != index){
					swap(array, i, index);
				}
			}
		}
		
		return index;
	}
	private void swap(int[] array, int i, int index) {
		// TODO Auto-generated method stub
		
		if (i == index){
			return;
		}
		
		int temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
}
