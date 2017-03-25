/**
 * 文件名：HeapSort.java
 * 所在包：sort
 * 日期：2014-3-21 上午11:12:40
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
 * 类名称：HeapSort
 * 类描述：堆排序，此处使用大顶堆
 * 创建人：黄传聪,参考：http://blog.csdn.net/xiaoxiaoxuewen/article/details/7570621
 * 创建时间：2014-3-21 上午11:12:40
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class HeapSort {

	/*堆排序：
	 * 1. 首先建立一个大顶堆（小顶堆），此时堆顶元素为最大（最小）值。
	 * 2. 
	 * 
	 * */
	MaxHeap maxHeap = null;
	private void createMaxHeap(int size, int[] arrs){
		
		maxHeap = new MaxHeap(size);
		maxHeap.arrs = arrs;
//		maxHeap.create();
//		for(int i : maxHeap.arrs){
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	
	public void sort(int size, int[] arrs){
		createMaxHeap(size, arrs);
		maxHeap.sort();
	}
	
	
	//堆排序算法分为两个部分
	//1. 使用shifDown形成初始堆
	//2. 通过一系列的元素交换和重新调整堆进行排序s
	/**
	 *
	 * 项目名称：data_structure
	 * 类名称：MaxHeap
	 * 类描述：大顶堆数据机构
	 * 创建人：黄传聪
	 * 创建时间：2014-3-21 上午11:36:52
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class MaxHeap{
		
		/** 大顶堆的长度    */    
		public int maxSize;
		/**  大顶堆包含的数据  */    
		public int[] arrs;
		public MaxHeap(int maxSize) {
			this.maxSize = maxSize;
			arrs = new int[maxSize];
		}
		
		/**
		 * 方法名称：create()
		 * 方法描述：建堆过程，自顶向下将数组变成堆
		 * @param  
		 * @return String    
		 * @Exception 
		 */
		public void create(){
			
			for(int i=0;i<=maxSize/2 - 1;i++){
//				shifDownRecursion(i,maxSize);
				shifDownByIter(i,maxSize-i);
			}
		}

		/**
		 * 方法名称：shifDown()
		 * 方法描述：向下调整
		 * 从parent到maxSize为止，自上往下比较，如果子女的值大于父节点的值，则大子女上升，父节点下降到大子女的位置
		 * @param  
		 * @return String    
		 * @Exception 
		 */
		private void shifDownRecursion(int parent, int maxSize) {
			// TODO Auto-generated method stub
			int lChild = 2 * parent + 1;
			int rChild = 2 * parent + 2;
			int max = parent;//最大节点位置
			
			if(parent < maxSize/2 ){
				if(lChild<maxSize && arrs[lChild] > arrs[max]){
					
					max = lChild;
				}
				if(rChild<maxSize && arrs[rChild]>arrs[max]){
					max = rChild;
				}
				//需要调整
				if(max != parent){
					swap(parent, max);
					//对以max为堆顶的堆进行调整
					shifDownRecursion( max, maxSize);
				}
			}
			
			
		}
		
		/**
		 * 方法名称：shifDownByIter()
		 * 方法描述：使用迭代方式，调整堆
		 * @param  
		 * @return String    
		 * @Exception 
		 */
		private void shifDownByIter(int parent, int maxSize){
			int lChild = 2 * parent + 1;
			int temp;
			while(lChild < maxSize){
				temp = arrs[parent];
				//寻找左右孩子中最大的那个
				if(lChild < maxSize && arrs[lChild + 1] > arrs[lChild]){
					lChild++;
				}
				//判断最大孩子与父亲节点的大小关系
				if(arrs[lChild] <= arrs[parent]){
					break;//不处理
				}else{
					//交换后，可能要进行调增
					arrs[parent] = arrs[lChild];
					arrs[lChild] = temp;
					//以最大节点为根的堆，进行堆处理
					parent = lChild;
					lChild = 2 * lChild + 1;
					
				}
				System.out.println(Arrays.toString(arrs));
			}
		}
		
		public void sort(){
			for(int i=maxSize-1;i>0;i--){
				shifDownByIter(0, i);
				swap(0,i);//交换堆顶和最后一个元素
				//重新调整
//				shifDownRecursion( 0, i);
			}
		}
		
		
		private void swap(int a, int b){
			int temp = arrs[a];
			arrs[a] = arrs[b];
			arrs[b] = temp;
		}
		
		
	}
	
	/**
	 * 方法名称：buildMaxHeap()
	 * 方法描述：迭代方法对数组实现从0-lastIndex建立大顶堆
	 * @param  lastIndex: 表示最后一个叶子结点
	 * @return String    
	 * @Exception 
	 */
	private static void buildMaxHeap(int[] data, int lastIndex){
		
		//从最后一个非叶子节点（也就是最后一个父节点）开始,
		for(int i=(lastIndex-1)/2; i>=0; i++){
			//保存当前正在判断的节点位置
			int k = i;
			while(k * 2 + 1 <= lastIndex){
				//设定最大的子节点索引
				int biggerIndex = 2 * k + 1;
				
				//若其有右子树节点
				if(biggerIndex < lastIndex){
					if(data[biggerIndex] < data[biggerIndex + 1]){
						biggerIndex += 1;
					}
				}
				
				//判断最大子树节点与父节点的大小关系
				
				if(data[biggerIndex] > data[k]){
					int temp = data[biggerIndex];
					data[biggerIndex] = data[k];
					data[k] = temp;
					
					//记录最大节点调换位置，进行下一步的调整
					biggerIndex = k;
				}else{
					break;
				}
			}
		}
	}
	
	private void iterHeapSort(int[] data){
		int length = data.length;
		for(int i=0;i<length;i++){
			buildMaxHeap(data, length-i-1);
			int temp = data[0];
			data[0] = data[length - i -1];
			data[length-i-1] = temp;
			
		}
	}
	
	
	public static void main(String[] args){
		HeapSort sort = new HeapSort();
		int[] arrs = {0,16,20,3,11,17,8};
		sort.sort(7, arrs);
		for(int i : sort.maxHeap.arrs){
			System.out.print(i + " ");
		}
	}
}
