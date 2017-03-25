/**
 * 文件名：ShellTest.java
 * 所在包：sort
 * 日期：2014-3-17 上午11:03:46
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：ShellTest
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-17 上午11:03:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ShellTest {

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
		shellSort(a);
		print(a);
	}
	private static void shellSort(int[] a) {
		// TODO Auto-generated method stub
		//步长，也就是组内元素之间的间距
		int step = a.length / 2;
		//step最小值为1
		while(step > 0){
			
			//组内进行简单插入排序
			for(int i=step;i<a.length;i++){
				//从右向左寻找插入点，j为i的左侧元素
				//
				int j = i - step;
				int key = a[i];
				for(;j>=0 && key < a[j];j -= step){
					a[j+step] = a[j];
				}
				a[j+step] = key;
			}
			
			//组内进行简单选择排序
//			for(int i=step;i<a.length;i++){
//				int max = a[i];
//				int k = i;
//				for(int j=i-step;j>=0;j -= step){
//					if(a[j] > max){
//						max = a[j];
//						k = j;
//					}
//				}
//				if(i != k){
//					a[k] = a[i];
//					a[i] = max;
//				}
//			}
			step /= 2;
		}
	}
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for(int i=0;i<a.length;i++){
			System.out.print(a[i] + " ");
		}
	}
}
