/**
 * 文件名：ValidSudoku.java
 * 所在包：leetcode
 * 日期：2014-10-28 下午12:07:57
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：ValidSudoku
 * 类描述：验证九宫格是否是合法的:http://sudoku.com.au/TheRules.aspx,九宫格规则
 * 1. 检查行是否合法
 * 2. 检查列是否合法
 * 3. 检查九个格子是否合法
 * 创建人：黄传聪
 * 创建时间：2014-10-28 下午12:07:57
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ValidSudoku {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] board = 
		{
				{'5','3','.','.','7','.','.','.','.'},
				{'6','.','.','1','9','5','.','.','.'},
				{'.','9','8','.','.','.','.','6','.'},
				{'8','.','.','.','6','.','.','.','3'},
				{'4','.','.','8','.','3','.','.','1'},
				{'7','.','.','.','2','.','.','.','6'},
				{'.','6','.','.','.','.','2','8','.'},
				{'.','.','.','4','1','9','.','.','5'},
				{'.','.','.','.','8','.','.','7','9'},
				
		};
		
		System.out.println(isValidSudoku(board));
	}
	
	 public static boolean isValidSudoku(char[][] board) {
	    
		 if (board==null || board.length<=0){
			 return false;
		 }
		 
		 int m = board.length, n = board[0].length;
		 int[] exist = new int[10];
		 //对于一行
		 for (int i=0; i<m; i++){
			 Arrays.fill(exist, 0);
			 for (int j=0; j<n; ++j){
				 char c = board[i][j];
				 if (c != '.'){
					 if (exist[c-'0'] > 0){
						 return false;
					 } else{
						 exist[c-'0'] = 1;
					 }
				 }
			 }
		 }
		 
		 //对于一列
		 for (int i=0; i<m; i++){
			 Arrays.fill(exist, 0);
			 for (int j=0; j<n; ++j){
				 char c = board[j][i];
				 if (c != '.'){
					 if (exist[c-'0'] > 0){
						 return false;
					 } else{
						 exist[c-'0'] = 1;
					 }
				 }
			 }
		 } 
		 //对于九宫格
		 Arrays.fill(exist, 0);
		 
		 for (int row=0; row<3; ++row){
			 for (int columns=0; columns<3; ++columns){
				 Arrays.fill(exist, 0);
				 for (int i=row*3; i<row*3+3; ++i){
					 for (int j=columns*3; j<columns*3+3; ++j){
						 char c = board[j][i];
						 if (c != '.'){
							 if (exist[c-'0'] > 0){
								 return false;
							 } else{
								 exist[c-'0'] = 1;
							 }
						 }
					 }
				 }
			 }
		 }
		 
		 return true;
		 
	 }

}
