/**
 * 文件名：Sqrt.java
 * 所在包：leetcode
 * 日期：2014-9-22 下午11:09:24
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Sqrt
 * 类描述：求一个正整数N的开方，要求不能用库函数sqrt()，结果的精度在0.001
 * 创建人：黄传聪
 * 创建时间：2014-9-22 下午11:09:24
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Sqrt {

	public static double sqrt (int n){
		
		if (n < 2){
			return n;
		} 
		
		double x = n / 2;
		double y = (x + n/x)/2;
		
		while (Math.abs(y - x) > 0.001){
			x = y;
			y = (x + (n/x)) / 2;
		}
		return y;
	}
	
	public static int sqrtByBinarySearch(int n){
		
		if (n < 2){
			return n;
		}
		
		//采用二分查找实现[1,n]
		
		int begin = 1;
		int end = n / 2;
		int mid = 0;
		int result = 0;
		while (begin <= end){
			
			//防止begin+end产生溢出
			mid = begin + ((end - begin) >> 1);
			if (mid == n / mid){ //防止mid*mid产生溢出
				return mid;
			} else if(mid < n / mid){
				result = mid;
				begin = mid + 1;
			} else {
				end = mid - 1;
			}
		
		}
		
		return result;
	}
	public static void main(String[] args) {
		System.out.println((int)sqrt(8));
//		System.out.println(Math.sqrt(3));
//		
//		int j = 0;
//		for (int i=0; i<100; ++i){
//			 j = j++;
//		}
//		
//		System.out.println(j);
//		
//		char x = 'x';
//		
//		System.out.println(false ? j : x);
//		System.out.println(false ? 10 : x);
//		
//		int n = 5;
//		System.out.println(n++ == 6);
//		System.out.println(n);
		
		System.out.println(sqrtByBinarySearch(8));
	}
}
