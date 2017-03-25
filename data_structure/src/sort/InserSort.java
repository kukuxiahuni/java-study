/**
 * 文件名：InserSort.java
 * 所在包：sort
 * 日期：2014-3-14 下午9:05:56
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
 * 类名称：InserSort
 * 类描述：直接出入排序
 * 创建人：黄传聪
 * 创建时间：2014-3-14 下午9:05:56
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InserSort {

	
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,4,2,1,45,0};
		sortWithBS(a);
//		print(a);
		
	}
	
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}

	
	/**
	 * 方法名称：sort()
	 * 方法描述：按照升序排序
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void sort(int[] arrs){
		for(int i=1;i<arrs.length;i++){
			int temp = arrs[i];
			int j = i - 1;
			for(;j>=0 && temp < arrs[j];j--){
				if(temp < arrs[j]){
					arrs[j+1] = arrs[j];
				}/*else{
					break;
				}*/
			}
			arrs[j+1] = temp;
		}
		//第二种写法
		/*for(int i=1;i<arrs.length;i++){
			int temp = arrs[i];
			int j = i-1;
			while(j>-1 && temp < arrs[j]){
				arrs[j+1] = arrs[j];
				j--;
			}
			arrs[j+1] = temp;
		}*/
	}
	
	/**
	 * 方法名称：sortWithBS()
	 * 方法描述：简单插入排序，采用二分查找查找插入点
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void sortWithBS(int[] arrs){
		
		for(int i=1;i<arrs.length;i++){
			int temp = arrs[i];
			
			int low = 0;
			int high = i - 1;
			
			while(low <= high){
				int mid = (low + high) / 2;
				
				if(arrs[i] < arrs[mid]){
					high = mid - 1;
				}else if(arrs[i] > arrs[mid]){
					low = mid + 1;
				}
			}
			
			//将low-i的元素向后移动
			for(int j = i;j > low;j--){
				arrs[j] = arrs[j-1];
			}
			
			arrs[low] = temp;
			
			
			System.out.println(Arrays.toString(arrs));
		}
	}

}
