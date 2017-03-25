/**
 * 文件名：MergeSortByIter.java
 * 所在包：sort
 * 日期：2014-3-25 上午9:55:13
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：MergeSortByIter
 * 类描述：采用迭代方式实现二路归并算法
 * 创建人：黄传聪
 * 创建时间：2014-3-25 上午9:55:13
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MergeSortByIter {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={ 7,6,5,4,3,2,1};
		mergeSort(a);
		

	}
	
	public static void mergeSort(int[] a){
		int length = a.length;
		int[] tempArr = new int[length];
		//归并的步长，初始为1，每次翻倍
		int step = 1;
		
		while(step < length){
			MergePass(a,tempArr,step);
			step *= 2;
			MergePass(tempArr,a,step);
			step *= 2;
		}
		
		for(int h : a){
			System.out.print(h + " ");
		}
	}

	private  static void MergePass(int[] a, int[] tempArr, int len) {
		// TODO Auto-generated method stub
		//由i控制起始位置
		int i = 0;
		while(i + 2 * len <= a.length-1){
			merge(a,tempArr,i,i+len-1,i+2*len-1);
			i = i + 2 * len;
		}
		
		//剩余两个归并项，最后一个归并项长度不足len
		if(i+len <= a.length-1){
			merge(a,tempArr,i,i+len-1,a.length-1);
		}else{
			//只剩下一个归并项，复制
			int j = i;
			for(;j<a.length;j++){
				tempArr[j] = a[j];
			}
		}
	}

	/**
	 * 方法名称：merge()
	 * 方法描述：执行2路归并
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private  static void merge(int[] a, int[] tempArr, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int i = left;
		int j = mid + 1;
		int index = 0;
		while(i<=mid && j<=right){
			if(a[i]<=a[j]){
				tempArr[index++] = a[i++];
			}else{
				tempArr[index++] = a[j++];
			}
		}
		
		while(i<=left){
			tempArr[index++] = a[i++];
		}
		while(j<=right){
			tempArr[index++] = a[j++];
		}
	}

}
