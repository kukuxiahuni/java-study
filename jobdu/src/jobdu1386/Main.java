/**
 * 文件名：Main.java
 * 所在包：jobdu1386
 * 日期：2014-10-9 上午9:30:19
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1386;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-9 上午9:30:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	
	private static  int binarySearch(int[] array){
		
		if (array == null || array.length <= 0){
			throw new IllegalArgumentException("数组为空或数组中不含有值");
		}
		
		int begin = 0; //begin始终指向第一个排序数组中的元素
		int end = array.length - 1; //end始终指向最后一个排序数组中的元素
		
		int mid = begin; //防止数组未旋转的情况
		
		while (array[begin] >= array[end]){
			
			if (end - begin == 1){  //如果begin 和 end相差为1， 说明begin指向了第一个数组的最后一个元素，而end指向了第二个数组的第一个元素
				mid = end;
				break;
			}
			mid = begin + ((end - begin) >> 1);
			//数组中存在重复元素，导致不能确定mid指针位于第几个数组中时，采用顺序查找获取结果
			if (array[begin] == array[end] && array[begin] == array[mid]){
				//顺序查找
				return linerSearch(array, begin, end);
			} 
			
			if (array[mid] >= array[begin]){
				begin = mid;
			} else if (array[mid] <= array[end]){
				end = mid;
			}
		}
		
		return array[mid];
		
		
	}

	private static int linerSearch(int[] array, int begin, int end) {
		// TODO Auto-generated method stub
		
		int min = array[begin];
		int index = begin;
		for (int i=begin + 1; i<array.length; ++i){
			if (min > array[i]){
				min = array[i];
				index = i;
			}
		}
		return array[index];
	}
	
	public static void main(String[] args) throws IOException {
		
//		Scanner scanner = new Scanner(System.in);
		StreamTokenizer stream = new StreamTokenizer(new InputStreamReader(System.in));
		
		while (stream.nextToken() != StreamTokenizer.TT_EOF){
			int n = (int) stream.nval;
			int[] array = new int[n];
			for (int i=0; i<n; ++i){
				if (stream.nextToken() != StreamTokenizer.TT_EOF){
					array[i] = (int) stream.nval;
				}
			}
			int result = binarySearch(array);
			System.out.println(result);
		}
		
	}
}
