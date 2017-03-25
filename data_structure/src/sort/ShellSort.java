/**
 * 文件名：ShellSort.java
 * 所在包：sort
 * 日期：2014-3-14 下午9:32:35
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：ShellSort
 * 类描述：希尔排序是一种插入排序，具体表现在各组内部排序中（使用的是简单插入排序）
 * 创建人：黄传聪
 * 创建时间：2014-3-14 下午9:32:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ShellSort {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {1,3,4,2,5,9,7,5,4,0,4,489,5,6,33,55,32,31,21};
		shellSort1(a);
		print(a);
	}

	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}

	/**
	 * 方法名称：shellSort()
	 * 方法描述：普通希尔排序，采用的长度为length/2
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void shellSort(int[] a) {
		// TODO Auto-generated method stub
 		int length = a.length / 2;
		while(length > 0){
			
			//各组进行排序(注意每组的数据不一定是两个，可能是多个)
			//i到a.length之间都是分组
			for(int i=length;i<a.length;i++){
				int j = i - length;
				int temp = a[i];
				//分组内部进行简单插入排序
				while(j>=0 && a[j] > temp){
					a[j + length] = a[j];
					j = j - length;
				}
				a[j + length] = temp;
			}
			length /= 2;
		}
		
	}
	
	/**
	 * 方法名称：shellSort1()
	 * 方法描述：采用Knuth的时间间隔
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void shellSort1(int[] a){
		
		int length = a.length;
		int interval = 1;
		while(interval <= length / 3){
			interval = interval * 3 + 1;
		}
		
		while(interval > 0){
			
			for(int i=interval;i<length;i++){
				int temp = a[i];
				
				int j = i - interval;
				
				while(j>=0 && a[j] > temp){
					a[j+interval] = a[j];
					j -= interval;
				}
				
				a[j+interval] = temp;
			}
			
			interval = (interval - 1) / 3;
		}
	}

}
