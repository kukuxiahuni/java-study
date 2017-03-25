/**
 * 文件名：SpiralMatrix.java
 * 所在包：leetcode
 * 日期：2014-9-15 上午11:25:19
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：SpiralMatrix
 * 类描述：按圈打印二维数组
 * 创建人：黄传聪
 * 创建时间：2014-9-15 上午11:25:19
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SpiralMatrix {

	 public int[][] generateMatrix(int n) {
		 
		 if (n <= 0){
			 return null;
		 }
		 int[][] results = new int[n][n];
		 
		 int num = 1;
		 int x = 0, y = 0;
		 results[0][0] = 1;
		 while (num < n*n){
		
		 // 填充第一行
			 while (y+1<n && results[x][y+1] == 0){
				 results[x][++y] = ++num;
			 }
		 //填充最后一列
			 while (x+1<n && results[x+1][y] == 0){
				 results[++x][y] = ++num;
			 }
		 //填充最后一行
			 while (y-1>=0 && results[x][y-1] == 0){
				 results[x][--y] = ++num;
			 }
		 //填充第一列
			 while (x-1>=0 && results[x-1][y] == 0){
				 results[--x][y] = ++num;
			 }
		 }
		 
		 for (int i=0; i<n; ++i){
			 System.out.println(Arrays.toString(results[i]));
		 }
		 
		return results;
	        
	        
	 }
	 
	 /**
	 * 方法名称：spiralOrder()
	 * 方法描述：leetcode
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
	   
		if (matrix==null || matrix.length<=0){
			return null;
		}
		
		int rows = matrix.length, columns = matrix[0].length;
		List<Integer> results = new ArrayList<>(rows*columns);
		int begin = 0;
		while (begin*2<rows && begin*2<columns){
			print(matrix, begin, rows, columns, results);
			++begin;
		}
		return results;
	}
	 private void print(int[][] matrix, int begin, int rows, int columns, List<Integer> results) {
		// TODO Auto-generated method stub
		int endX = columns - begin - 1, endY = rows - begin - 1;
		
		//打印第一行
		for (int i=begin; i<=endX; ++i){
			results.add(matrix[begin][i]);
		}
		
		//打印最后一列
		for (int i=begin+1; i<=endY; ++i){
			results.add(matrix[i][endX]);
		}
		
		//打印最后一行
		if (endY>begin){
			for (int i=endX-1; i>=begin; --i){
				results.add(matrix[endY][i]);
			}
		}
		
		//打印第一列
		if (endX > begin){
			
			for (int i=endY-1; i>=begin+1; --i){
				results.add(matrix[i][begin]);
			}
		}
	}

	public static void main(String[] args) {
		SpiralMatrix ma = new SpiralMatrix();
		int[][] matrix = 
			{
				{1,2,3},
				{4,5,6},
				{7,8,9}
			};
		System.out.println(ma.spiralOrder(matrix));
//		
//		ma.generateMatrix(3);
//		ma.generateMatrix(4);
//		ma.generateMatrix(1);
//		 
//		 int i = -67;
//		 
//		 int j = ~i;
//		 System.out.println(Integer.toBinaryString(i));
//		 System.out.println(Integer.toBinaryString(67));
		 
//		 int i = 0;
//		 int j = 0;
//		 int k = 0;
//		 i = i++ + ++i + i++ + i++;
//		 j = ++j + ++j + j++ + j++;
//		 
//		 k = k++;
//		 System.out.println(i + " , " + j + " , " + k);

	}
}
