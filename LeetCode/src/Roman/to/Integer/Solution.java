package Roman.to.Integer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-5 下午9:49:33
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    
	private final Map<Character,Integer> map ;
	
	public Solution(){
		map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}
    public int romanToInt(String s) {
        int pre = 0;
        int cur = 1;
        int count = 0;
        for(pre=0,cur=1;cur<s.length();++pre,++cur){
        	int preNum =  map.get(s.charAt(pre));
        	int curNum =  map.get(s.charAt(cur));
        	if(preNum< curNum){
        		count -= preNum;
        	}else{
        		count += preNum;
        	}
        }
        
        count += map.get(s.charAt(pre));
        
        return count;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.romanToInt("MMIMM"));
	}
}