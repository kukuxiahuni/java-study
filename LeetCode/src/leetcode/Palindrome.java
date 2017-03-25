/**
 * 文件名：Palindrome.java
 * 所在包：leetcode
 * 日期：2014-11-12 下午9:35:03
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Palindrome
 * 类描述：回文数算法，将数字逆置，也就是最低位放到最高位上，重新构成一个新的数字后判断这两个数字是否相等
 * 创建人：黄传聪
 * 创建时间：2014-11-12 下午9:35:03
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Palindrome {

	  public static boolean isPalindrome(int x) {
	        
	     if (x < 0){
	         return false;
	     }
	     
	     int result = getPalindrome(x);
	     return result == x;
	 }

	private static int getPalindrome(int x) {
		// TODO Auto-generated method stub
		int result = 0;
		while (x > 0){
			result *= 10;
			result += x % 10;
			x /= 10;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome(12344321));
	}
}
