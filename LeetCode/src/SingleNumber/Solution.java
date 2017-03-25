package SingleNumber;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-7-29 下午9:32:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 * 
 * 题目描述：
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
	Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
 * @version
 */
public class Solution {
	
    /**
     * 方法名称：singleNumber()
     * 方法描述：采用XOR（异或）方式解答：
     * @param  
     * @return String    
     * @Exception 
     */
    public int singleNumber(int[] A) {
        int result = A[0];
        for(int i=1;i<A.length;i++){
            result = result^A[i];
        }
        return result;
    }
    
    
    /**
     * 方法名称：singleNumber()
     * 方法描述：采用排序方式解答
     * @param  
     * @return String    
     * @Exception 
     */
    public int singleNumberSort(int[] A){
    	
    	if(A.length == 1){
    		return A[0];
    	}
    	//按照升序排列
    	Arrays.sort(A);
    	//排序之后，相同的数字成对存在 如 1,2,2,3,3；2,2,3,4,4；故此设定递增步长为2
    	for(int i=0;i<A.length-1;i+=2){
    		if(A[i] != A[i+1]){
    			return A[i];
    		}
    	}
    	//极端情况，单个数为数列中的最大值
    	return A[A.length-1];
    }
    
    public int  singleNumberWithExtraSpace(int[] A){
    	HashMap<Integer, Integer> map = new HashMap<>();
    	
    	for(int i=0;i<A.length;i++){
    		int value = 0;
    		if(map.containsKey(A[i])){
    			map.remove(A[i]);
    		}else{
    			
    			map.put(A[i], value+1);
    		}
    	}
    	return map.entrySet().iterator().next().getKey();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
		Solution s = new Solution();
		int[] a = {2,2,3,3,4,5,5};
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:/data.txt"));
		//数据重定向
		System.setIn(in);
		Scanner scanner = new Scanner(System.in);
		String string = scanner.nextLine();
		String[] strs = string.split(",");
		int[] nums = new int[strs.length];
		int index = 0;
		for(String str : strs){
			nums[index] = Integer.parseInt(str);
			++index;
		}
		
		System.out.println(s.singleNumberSort(nums));
		System.out.println(s.singleNumberWithExtraSpace(nums));
	}
}