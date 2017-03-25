/**
 * 文件名：MergeSort.java
 * 所在包：sort
 * 日期：2014-3-24 上午9:11:23
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;


/**
 *
 * 项目名称：data_structure
 * 类名称：MergeSort
 * 类描述：归并排序，使用的是2路归并
 * 创建人：黄传聪
 * 创建时间：2014-3-24 上午9:11:23
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MergeSort {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 1, 3, 4 ,4,6,9,2,4,3,12,3,4,11,3332,44,23};
		mergeSort(a, 0, a.length-1);
		for(int h : a){
			System.out.print(h + " ");
		}

	}
	
	/**
	 * 方法名称：mergeSort()
	 * 方法描述：此处的right为最后一个元素的位置
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void mergeSort(int[] arrs, int left, int right){
		if(left < right){
			
			int mid = (left + right) / 2;
			mergeSort(arrs, left, mid);
			mergeSort(arrs, mid+1,right);
			Merge(arrs,left,mid,right);
		}
		
	}

	/**
	 * 方法名称：Merge()
	 * 方法描述：对分开的两个数组进行归并
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void Merge(int[] arrs, int left, int mid, int right) {
		// TODO Auto-generated method stub
	
		//此处为当前部分数组的长度
		int length = right - left + 1;
		int i = left;
		int j = mid + 1;
		
		//临时数组
		int[] temp = new int[length];
		//temp数组指针
		int index = 0;
		//数组归并的过程，也就是一个排序的过程
		while(i<=mid && j<=right){
			if(arrs[i] <= arrs[j]){
				temp[index++] = arrs[i++];
			}else{
				temp[index++] = arrs[j++];
			}
			
		}
		
		//若做半侧未检测完成
		while(i<=mid){
			temp[index++] = arrs[i++];
		}
		//若右半侧未检测完
		while(j<=right){
			temp[index++] = arrs[j++];
		}
		//完成后，将结果复制回原有的数组
		index = 0;
		for(i=left;i<=right;i++){
			arrs[i] = temp[index++];
		}
	}

}
