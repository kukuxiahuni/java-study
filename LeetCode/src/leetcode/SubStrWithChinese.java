/**
 * 文件名：SubStrWithChinese.java
 * 所在包：leetcode
 * 日期：2014-10-6 上午9:32:18
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.io.UnsupportedEncodingException;

/**
 *
 * 项目名称：LeetCode
 * 类名称：SubStrWithChinese
 * 类描述：截取含有中文的字符串。
 * 注意： 1. 中文占两个字节，char类型为两个字节。
 * 		 2. substring按照 char进行截取， ‘我’ 和 ‘a'都是一个char。故本题不能使用substring直接截取
 * 		 3. GBK 汉字占两个字节， UTF-8汉字占三个字节
 * 		 4. 汉字不可以截半，汉字截半的话对应字节的ASC码为小于0的数值
 * 参考 http://blog.csdn.net/zhb123168/article/details/8083936
 * 见《java程序员面试宝典2》 p194
 * 创建人：黄传聪
 * 创建时间：2014-10-6 上午9:32:18
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SubStrWithChinese {

	
	public static String subString (String str, int count ) throws UnsupportedEncodingException{
		
		if (str != null && !"".equals(str)){
			
			byte[] bytes = str.getBytes("GBK");
			
			int byteLen = bytes.length;
			
			count = count > byteLen ? byteLen : count;
			
			if (bytes[count] < 0){
				--count;
			}
			
			return new String(bytes, 0, count, "GBK");
		}
		
		return str;
	}
	public static void main(String[] args) {
		try {
//			System.out.println(new String(subStr("我ABC", 4).getBytes("GBK"), "GBK"));
			System.out.println(subString("我ABC汉def", 6));
			System.out.println(subString("我ABC", 4));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
