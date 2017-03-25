/**
 * 文件名：TestAnswers.java
 * 所在包：junit.test
 * 日期：2014-8-29 下午3:27:25
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package junit.test;


import java.util.Arrays;

import leetcode.Duplicates;
import leetcode.LongestConsecutive;
import leetcode.Median;
import leetcode.RotatedArray;
import leetcode.TwoSum;

import org.junit.Test;

/**
 *
 * 项目名称：LeetCode
 * 类名称：TestAnswers
 * 类描述：用于进行算法测试
 * 创建人：黄传聪
 * 创建时间：2014-8-29 下午3:27:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class TestAnswers {

	@Test
	public void test(){
		Median m = new Median();
		
		int[] B = {1};
		int[] A = {2,4};
		System.out.println(m.findMedianSortedArrays(A, B));
		System.out.println(m.findMedianByMergeSort(A, B));
		System.out.println(m.findMedian(A, B));
	}
	
	@Test
	public void testDuplicates(){
		
		int[] A = {1,1,1,2};
		Duplicates d = new Duplicates();
		System.out.println(d.removeDuplicates(A));
	}
	
	@Test
	public void TestRotated(){
		
		int[] A = {5,1,3};
		int[] B = {3, 1};
		int[] C = {1, 3};

		RotatedArray r = new RotatedArray();
		
//		System.out.println(r.search(A, 7));
//		System.out.println(r.search(B, 1));
//		System.out.println(r.search(C, 3));
		System.out.println(r.search(A, 3));
	}
	
	/**
	 * 方法名称：testLongest()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	@Test
	public void testLongest(){
		
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		int[] A = {100, 4, 200, 1, 3, 2};
		System.out.println(longestConsecutive.longestConsecutive(A));
	}
	
	@Test
	public void testTwoSum(){
		
		TwoSum twoSum = new TwoSum();
		int[] A = {1,1,1,1};
		System.out.println(Arrays.toString(twoSum.twoSum(A, 2)));
	}
	
}
