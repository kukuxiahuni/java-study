/**
 * 文件名：SimpleSelectSort.java
 * 所在包：sort
 * 日期：2014-3-17 上午10:20:45
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：SimpleSelectSort
 * 类描述：
 * 1. 查找待排序记录中最小的记录，并将它与该区间的第一个记录交换
 * 2. 重复1，知道n-1次排序后结束。
 * 创建人：黄传聪
 * 创建时间：2014-3-17 上午10:20:45
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SimpleSelectSort {

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
		simpleSelectSort(a);
		print(a);
		
	}
	
	private static void simpleSelectSort(int[] a){
		int min ;
		
		for(int i=0;i<a.length;i++){
			min = a[i];
			//表示最小值的位置
			int k = i;
			int j;
			//寻找改组中的最小值
			for(j = i+1;j<a.length;j++){
				if(a[j] < min){
					min = a[j];
					k = j;
				}
			}
			if(i != k && k < a.length){
				//交换元素位置
				a[k] = a[i];
				a[i] = min;
			}
		}
	}
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
