/**
 * 文件名：CountAndSay.java
 * 所在包：leetcode
 * 日期：2014-11-12 下午10:39:57
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：CountAndSay
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-12 下午10:39:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class CountAndSay {
	
	public static String countAndSay(int n) {
        
		if (n < 0){
			return "";
		}
		String result = "1";
		for (int i=1; i<n; ++i){
			result = generator(result);
		}
		return result;
    }

	private static String generator(String str) {
		StringBuilder stringBuilder = new StringBuilder();
		
		char[] chs = str.toCharArray();
		
		int slow = 0, fast = 0;
		int len = chs.length;
		
		while (slow < len){
			int count = 1;
			fast = slow + 1;
			
			while (fast < len && chs[slow] == chs[fast]){
				++count;
				++fast;
			}
			
			stringBuilder.append(count);
			stringBuilder.append(chs[slow]);
			
			slow = fast;
		}
		
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
