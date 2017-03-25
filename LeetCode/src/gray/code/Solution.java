package gray.code;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-18 下午2:30:20
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    public List<Integer> grayCode(int n) {
      
    	List<Integer> results = new ArrayList<>();
    	
    	results.add(0);
    	for(int i=0; i<n; ++i){
    		int inc = 1 << i;
    		
    		for(int j=0; j<results.size(); --j){
    			
    			results.add(results.get(j) + inc);
    		}
    	}
        return results;
    }
    
    public static void main(String[] args) {
		System.out.println(1<<3);
	}
}