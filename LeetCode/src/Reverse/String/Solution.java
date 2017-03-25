package Reverse.String;
/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-27 下午5:00:54
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
	
    public String reverseWords(String s) {
        
    	if("".equals(s)){
    		return "";
    	}
    	s =s.replaceAll("\\s+", " ");
        String[] strs = s.split(" ");
    	if(" ".equals(s)){
    	    return "";
    	}
        StringBuilder string = new StringBuilder();
        
        for(String str : strs){
        	if(!"".equals(str)){
        		string.insert(0, str + " ");
        	}
        }
        return string.substring(0, string.length()-1);
        
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.reverseWords(" 1   "));
	}
}