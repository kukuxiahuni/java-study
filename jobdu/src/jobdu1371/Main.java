/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1371
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-下午1:36:52
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1371;

import java.util.Arrays;
import java.util.Scanner;


/**
 * 类名称： Main
 * 类描述：//
 *1. 使用快速排序进行
 *2. 使用堆排序（适合大数据）
 * 创建人：黄传聪
 * 2014年10月15日 下午1:36:52
 * @version 1.0.0
 */
public class Main {

	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午1:36:52
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			
			int m = scanner.nextInt();
			int k = scanner.nextInt();
			
			if (m <= 0){
				break;
			}
			
			int[] array = new int[m];
			for (int i=0; i<m; ++i){
				array[i] = scanner.nextInt();
			}
			
		/*	int begin = 0, end = m-1;
			
			int index = partition(array, 0, m-1);
			
			while (index != k-1){
				
				if (index < k-1){
					begin = index + 1;
					index = partition(array, begin, end);
				} else {
					end = index - 1;
					index = partition(array, begin, end);
				}
			}
			
			Arrays.sort(array, 0, k);
			for (int i=0; i<k; ++i){
				
				if (i == k-1){
					System.out.println(array[i]);
				} else {
					System.out.print(array[i] + " ");
				}
			}*/
			
			sort(array, k);
		}
	}
	
	
	private static int partition(int[] array, int begin, int end){
		
		if (array==null || array.length<=0 || begin<0 || begin>end || end >=array.length){
			throw new IllegalArgumentException("数组或起始位置输入有误");
		}
		
		int i = begin;
		int j = end;
		int flag = array[begin];
		while (i < j){
			
			while (i<j && array[j]>flag){
				--j;
			}
			
			if (i<j){
				array[i] = array[j];
				++i;
			}
			//从前往后找比flag小的数字后交换
			while (i<j && array[i]<flag){
				++i;
			}
			if (i < j){
				array[j] = array[i];
				--j;
			}
			
			
		}
		
		array[i] = flag;
		return i;
	}
	
	
	private static void swap (int[] array, int first, int end){
		
		if (array == null || first<0 || end<0 || end>array.length || first>array.length){
			throw new IllegalArgumentException("数组或起始位置输入有误");
		}
		
		int temp = array[first];
		array[first] = array[end];
		array[end] = temp;
		
	}
	
	//使用堆排序
	//1. 构建一个大小为K的大顶堆
	//2. 每次移除大顶的数据
	//3. 输出数据
	
	private static void shifDownByRecursion(int[] heap, int parent){
		
		if (heap == null || heap.length<=0 ){
			throw new IllegalArgumentException("输入参数有误");
		}
		
		int length = heap.length;
		if (parent >= length) return;
		int left = parent * 2 + 1, right = parent * 2 + 2;
		//如果左右孩子有大于父节点者，交换
		
		int max = heap[parent];
		int index = parent;
		
		if (parent < (length>>1)){
			
			if (left<length && max<heap[left]){
				max = heap[left];
				index = left;
			}
			
			if (right<length && max<heap[right]){
				max = heap[right];
				index = right;
			}
			
			if (index != parent){
				swap(heap, index, parent);
				shifDownByRecursion(heap, index);
			}
		}
		
		
	}
	
	private static void createHeap (int[] heap){
		
		if (heap==null || heap.length<=0){
			return;
		}
		
		int length = heap.length;
		
		for (int i=(length>>1)-1; i>=0; --i){
			
			shifDownByRecursion(heap, i);
		}
	}
	
	private static void sort(int[] array, int k){
		
		if (array==null || array.length<=0 || k<0 || k>array.length){
			throw new IllegalArgumentException("用户输入有误");
		}
		
		int[] heap = Arrays.copyOfRange(array, 0, k);
		createHeap(heap);
		int length = array.length;
		for (int i=k; i<length; ++i){
			if (array[i] < heap[0]){
				heap[0] = array[i];
				shifDownByRecursion(heap, 0);
			}
		}
		
		Arrays.sort(heap);
		for (int i=0; i<k; ++i){
			
			if (i == k-1){
				System.out.println(heap[i]);
			} else {
				System.out.print(heap[i] + " ");
			}
		}
	}
	

}
