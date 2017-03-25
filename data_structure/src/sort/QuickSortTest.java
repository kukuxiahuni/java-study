/**
 * 文件名：QuickSortTest.java
 * 所在包：sort
 * 日期：2014-3-17 上午11:45:25
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

import java.util.Arrays;

/**
 *
 * 项目名称：data_structure
 * 类名称：QuickSortTest
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-17 上午11:45:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class QuickSortTest {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] a = { 1, 3, 4 ,4,6,9,2,4,3,12,3,4,11,3332,44,23};
		int[] a = {5,2,7,-2,9,0,-9};
		sort(a,0,a.length-1);
		print(a);
	}
	
	private static void sort(int[] a, int begin, int end){
		
		int i = begin;
		int j = end;

		if(begin < end){
			//设置标志位
			int provit = a[begin];
			
			//一趟排序
			while(i < j){
				//从右向左查找比provit小的位置
				while(i < j && provit < a[j]){
					j--;
				}
				
				if(i < j){
					a[i] = a[j];
					i++;
				}
				
				while(i < j && provit > a[i]){
					i++;
				}
				if(i < j){
					a[j] = a[i];
				}
				
				System.out.println(Arrays.toString(a));
			}
			a[i] = provit;
			sort(a,begin,i-1);
			sort(a,i+1,end);
		}
	}
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}
}
