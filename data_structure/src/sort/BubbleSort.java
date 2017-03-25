/**
 * 文件名：BubbleSort.java
 * 所在包：sort
 * 日期：2014-3-14 下午10:47:42
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */

package sort;

import java.util.Arrays;

/**
 * 
 * 项目名称：data_structure 类名称：BubbleSort 类描述：冒泡排序与普通交换排序的不同，就是加了个交换标志位 创建人：黄传聪
 * 创建时间：2014-3-14 下午10:47:42 修改人： 修改时间： 修改备注：
 * 
 * @version
 */
public class BubbleSort {

	/**
	 * 方法名称：main() 方法描述：
	 * 
	 * @param
	 * @return String
	 * @Exception
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 1, 3, 4 ,4,6,9,2,4,3,12,3,4,11,3332,44,23};

		bubbleSort2(a);
		System.out.println(Arrays.toString(a));
	}

	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	private static void bubbleSort1(int[] a) {
		// TODO Auto-generated method stub
		boolean flag = true;

		int i = 0;
		while (flag && i < a.length) {
			//每趟排序都要重设标识位
			flag = false;
			for (int j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					flag = true;
				}
			}
			i++;
		}
		
	}
	
	private static void bubbleSort2(int[] a){
		
		for(int i=0;i<a.length;i++){
			boolean flag = false;
			
			for(int j=1;j<a.length-i;j++){
				if(a[j] < a[j-1]){
					int temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
					flag = true;
				}
			}
			
			if(!flag){
				break;
			}
		}
	}
	
	private static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub
		boolean flag = true;

		int i = 0;
		
		for(;i<a.length && flag;i++){
			flag = false;
			//进行一趟冒泡排序
			for(int j=1;j<a.length-i;j++){
				if(a[j-1] > a[j]){
					int temp = a[j-1];
					a[j-1] = a[j];
					a[j] = temp;
					flag = true;
				}
			}
		}
	}

}
