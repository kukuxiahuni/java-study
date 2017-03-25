/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1370
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-下午2:51:45
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1370;

import java.util.Scanner;
/**
 * 类名称： Main
 * 类描述：
 * 创建人：黄传聪
 * 2014年10月15日 下午2:51:45
 * @version 1.0.0
 */
public class Main {

	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午2:51:46
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			
			if (n <= 0){
				System.out.println(-1);
				break;
			}
			
			int[] array = new int[n];
			for (int i=0; i<n; ++i){
				array[i] = scanner.nextInt();
			}
			
			System.out.println(getNum(array));
			System.out.println(search(array, (n>>1)));
		}
	}

	private static int getNum(int[] array){
		
		if (array == null || array.length <= 0){
			return 0;
//			throw new IllegalArgumentException("数组输入有误");
		}
		
		int count = 1; //记录同一个数出现的次数，如果出现则加1 否则 减1，若count = 0调整result的数值
		int result = array[0];
		
		for (int i=1; i<array.length; ++i){
			
			if (result == array[i]){
				++count;
			} else{
				--count;
			}
			
			if (count == 0){
				result = array[i];
				count = 1;
			}
		}
		
		if (isLegal(array, result)){
			return result;
		} else {
			return -1;
		}
	}
	
	private static boolean isLegal(int[] array, int result){
		
		if (array == null || array.length <= 0){
			return false;
		}
		int count = 0;
		
		int length = array.length;
		for (int i=0; i<length; ++i){
			if (result == array[i]){
				++count;
			}
		}
		
		if (count >= (length>>1)){
			return true;
		} else{
			return false;
		}
	}
	
	//采用快排的思想
	/**
	 * 1. 重复度大于数组长度的一半，则数组升序排序，则数组的中间位置存储的数字为该数字，也就是说该数字是整个数字串的中位数
	 * 2. 此题为求第k大问题。使用快速排序解决。
	 * 
	 * 算法步骤：1. 随机选择一个数字，进行快速划分。
	 * 2. 如果该数字的位置为k-1则返回，若 index<k-1, 则 begin=index+1，否则end = index-1
	 */
	
	private static int partition(int[] array, int begin, int end){
		
		if (array==null || array.length<=0 || begin>end || begin<0 || end<=0|| begin>array.length ||end >array.length){
			throw new IllegalArgumentException("数组输入错误");
		}
		
		int i = begin;
		int j = end;
		
		int flag = array[begin];
		
		while (i<j){
			
			while(i<j && array[j] > flag){
				--j;
			}
			
			if (i<j){
				array[i] = array[j];
				++i;
			}
			
			while(i<j && array[i]<flag){
				++i;
			}
			
			if (i<j){
				array[j] = array[i];
				--j;
			}
		}
		
		array[i] = flag;
		return i;
	}
	
	private static int search(int[] array, int k){
		
		int begin = 0, end = array.length - 1;
		int index = partition(array, begin, end);
		
		while (index != k){
			if (index > k){
				end = index - 1;
				index = partition(array, begin, end);
			} else {
				begin = index + 1;
				index = partition(array, begin, end);
			}
		}
		
		int result = array[k];
		
		if (isLegal(array, result)){
			return result;
		} else{
			return -1;
		}
	}
}

