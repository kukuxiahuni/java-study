/**
 * 文件名：LongestSubstring.java
 * 所在包：leetcode
 * 日期：2014-10-31 下午10:18:05
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：LongestSubstring
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-31 下午10:18:05
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class LongestSubstring {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";//"wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco";
		System.out.println(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
        
		if (s==null || s.length()<=0){
			return 0;
		}
		//存储字符下标
		int[] chs = new int[256];
		Arrays.fill(chs, -1);
		int max = 0;
		int begin = 0;
		for (int i=0; i<s.length(); ++i){
			
//			if (chs[s.charAt(i)] == -1){
//				chs[s.charAt(i)] = i;
//			} else {
//				int len = 0;
//				int index = chs[s.charAt(i)];
//				chs[s.charAt(i)] = i;
//				if (index < begin){
//					continue;
//				}
//				
//				System.out.println(s.charAt(index) + " , " + index + " : " + s.charAt(i) + " , " + i);
//				max = max > (len = i - begin) ? max : len;
//				begin = index + 1;
//				System.out.println("begin : " + begin);
////				chs[s.charAt(i)] = i;
//			}
			
			//如下写法比较精炼
			if (chs[s.charAt(i)] >= begin){
				int len = 0;
				max = max > (len = i - begin) ? max : len;
				begin = chs[s.charAt(i)] + 1;
			}
			chs[s.charAt(i)] = i;
			
		}
		//最后一趟和字符串不包含重复数据
		max = max > (s.length()-begin) ? max : (s.length()-begin);
		return max;
    }

}
