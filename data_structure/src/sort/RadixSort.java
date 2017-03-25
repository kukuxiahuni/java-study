/**
 * 文件名：RadixSort.java
 * 所在包：sort
 * 日期：2014-3-27 上午9:53:20
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package sort;

/**
 *
 * 项目名称：data_structure
 * 类名称：RadixSort
 * 类描述：基数排序-LSD（最低位优先排序）
 * 该代码的难点有两个：1. 获取数字中每个位上面的数据。2. 获取数值在二维数组中的存储位置。
 * 创建人：黄传聪
 * 创建时间：2014-3-27 上午9:53:20
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RadixSort {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count  = 1;
		count = count++;
		System.out.println(count);
		int[] a = { 332,633,509,589,232,664,179,457,825,714,405,361};
		sort(a, 3);
		print(a);
	}
	
	/**
	 * 方法名称：sort()
	 * 方法描述：其中length表示数组中每个数据的长度
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void sort(int[] a,int length){
		if(a != null && a.length > 0){
			//其中midResult[i][0]处，记录改组数据的个数
			int[][] midResult = new int[10][a.length];
			for(int i=1;i<=length;i++){
				for(int j=0;j<a.length;j++){
					int pos = getNumPos(a[j], i);
					int index = ++midResult[pos][0];
					midResult[pos][index] = a[j];
				}
				//将二维数组中的元素复制到原有一维数组中,并将二维数组标志位置为1
				for(int j=0,pos=0;j<10;j++){
					
					for(int k=1;k<=midResult[j][0];k++){
						a[pos++] = midResult[j][k];
					}
					
					midResult[j][0] = 0; //如果数组中存储的是引用类型，则此处会出现内存泄露问题，应当将各个单元的值置为null
				}
			}
		}
	}
	
	/**
	 * 方法名称：getNumPos()
	 * 方法描述：num:数字，pos：表示要获取整形中第pos位数据,其中pos是从后往前计数。如556，第一位为6 
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int getNumPos(int num, int pos){
		int temp = 1;
		for(int i=0;i<pos-1;i++){
			temp *= 10;
		}
		return (num / temp) % 10;
	}
	
	private static void print(int[] a) {
		// TODO Auto-generated method stub
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
