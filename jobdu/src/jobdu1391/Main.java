/**
 * 文件名：Main.java
 * 所在包：jobdu1391
 * 日期：2014-10-14 下午4:35:46
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1391;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：顺时针打印数组
 * 创建人：黄传聪
 * 创建时间：2014-10-14 下午4:35:46
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()){
			
			int rows = scanner.nextInt();
			int columns = scanner.nextInt();
			if (rows == 0 || columns == 0){
				break;
			}
			
			int[][] matrix = new int[rows][columns];
			
			for (int i=0; i<rows; ++i){
				for (int j=0; j<columns; ++j){
					matrix[i][j] = scanner.nextInt();
				}
			}
			
			int start = 0;
			
			while (columns > start * 2 && rows  > start * 2 ){
				print(matrix, rows, columns, start);
				++start;
			}
		}
	}

	
	private static void print(int[][] matrix, int rows, int columns, int start){
		
		int columnsEnd = columns - 1 - start;
		int rowEnd = rows - 1 - start;
		
		//第一行
		for (int i=start; i<=columnsEnd; ++i){
			System.out.print(matrix[start][i] + " ");
		}
		
		//最后一列
		for (int i=start+1; i<=rowEnd; ++i){
			System.out.print(matrix[i][columnsEnd] + " ");
		}
		
		//最后一行
		for (int i=columnsEnd-1; i>= start; --i){
			System.out.print(matrix[rowEnd][i] + " ");
		}
		
		//第一列
		for (int i=rowEnd-1; i>=start+1; --i){
			System.out.print(matrix[i][start] + " ");
		}
	}
	
	
}
