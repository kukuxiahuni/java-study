/**
 * 文件名：QuickSort.java
 * 所在包：sort
 * 日期：2014-3-15 下午10:35:22
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

import java.util.Arrays;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * 项目名称：data_structure
 * 类名称：QuickSort
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-15 下午10:35:22
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class QuickSort {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int[] a = { 1, 3, 4 ,4,6,9,2,4,3,12,3,4,23};
		int[] a = {9 , -16, 21, 23 , -30 ,-49, 21, 30, 30};
		quickSort1(a, 0, a.length - 1);
		quickSortWith(a, 0, a.length-1);
		print(a);
	}
	
	/**
	 * 方法名称：quickSort()
	 * 方法描述：快速排序
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static boolean quickSort(int[] a,int begin, int end){
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
			}
			a[i] = provit;
			quickSort(a,begin,i-1);
			quickSort(a,i+1,end);
			return true;
		}
		return false;
	}
	/**
	 * 方法名称：quickSortWith()
	 * 方法描述：算法导论中的方法,推荐使用此种方法
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void quickSortWith(int[] array, int begin, int end){
		
		if (array == null || array.length<=0 || begin > end){
			return ;
		}
		
		int i = begin - 1, j = begin, provit = array[end];
		
		while (j<=end-1){
			
			if (array[j] <= provit){
				++i;
				swap(array, i, j);
			}
			++j;
		}
		
		swap(array, i+1, j);
		quickSortWith(array, begin, i);
		quickSortWith(array, i+2, end);
		
	}
	
	private static void quickSort1(int[] a, int begin, int end){
		
		int i = begin;
		int j = end + 1;
		
		if(begin < end){
			//设置标志位
			int provit = a[begin];
			
			while(i < j){
				
				//从右向左查找比provit小的元素，记录其位置
				while(i<j && a[--j] > provit){
				}
				//从左向右查找比provit大的元素，记录其位置
				while(i<j && a[++i] < provit){
				}
				
				//交换i 和 j的元素
				if(i < j){
					swap(a, i, j);
				}else{
					break;
				}
				
				System.out.println(Arrays.toString(a));
			}
			
			swap(a, i, begin);
			quickSort1(a, begin, i-1);
			quickSort1(a, i+1, end);
		}
		
		
	}
	
	private static void swap(int[] a, int i ,int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
