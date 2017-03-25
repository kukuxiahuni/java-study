/**
 * 文件名：Sum3.java
 * 所在包：leetcode
 * 日期：2014-10-28 上午10:36:06
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
 * 类名称：Sum3
 * 类描述：
 * 1. 先排序，采用左右夹逼的策略
 * 2. 确定a， 从a的下一个位置到数组结束，分别确定b和c，使得 b+c = -a；
 * 创建人：黄传聪
 * 创建时间：2014-10-28 上午10:36:06
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Sum3 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = {-1,0,1,2,-1,-4};
		 List<List<Integer>> results = threeSum(array);
		 
		 for (List<Integer> list : results){
			 System.out.println(list);
		 }
	}
	
	public static List<List<Integer>> threeSum(int[] num) {
        
		if (num==null || num.length<=2){
			return new ArrayList<List<Integer>>();
		}
		
		Set<List<Integer>> results = new HashSet<>();
		List<Integer> result = null;
		
		int length = num.length;
		Arrays.sort(num);
		int a,b,c;
		
		for (int i=0; i<length-2; ++i){
			
			a = num[i];
			int j = i + 1, k = length - 1;
			
			while (j < k){
				b = num[j];
				c = num[k];
				if (b + c == -a){
					result = new ArrayList<>();
					result.add(a);
					result.add(b);
					result.add(c);
					results.add(result);
					++j;
					--k;
				} else if (b + c > -a){
					--k;
				} else {
					++j;
				}
				
			}
		}
		
		return new ArrayList<>(results);
    }

}
