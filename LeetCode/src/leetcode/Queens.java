/**
 * 文件名：Queens.java
 * 所在包：leetcode
 * 日期：2014-10-6 下午9:43:00
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Queens
 * 类描述：n皇后问题，采用回溯+剪枝
 * 创建人：黄传聪
 * 创建时间：2014-10-6 下午9:43:00
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Queens {

	private int[] columns;
	private int[] lUrD;   //左上右下
	private int[] rUlD;	  //右上左下
	
	private int[] results; //存放结果集
	
	 public List<String[]> solveNQueens(int n) {
		 
		 List<String[]> result = new ArrayList<>();
		results = new int[n];
		columns = new int[n];
		lUrD = new int[2 * n - 1];
		rUlD = new int[2 * n - 1];
		 trail(0, n, result);
		 
		 return result;
	 }

	private void trail(int row, int n, List<String[]> result) {
		// TODO Auto-generated method stub
		if (row >= n){
			String[] strs = new String[n];
			StringBuilder sb = new StringBuilder();
			int index = 0;
			for (int k=0; k<n; ++k){
				for (int m=0; m<n; ++m){
					
					if (results[k] == m){
						sb.append("Q");
						System.out.print(" Q");
					} else{
						sb.append(".");
						System.out.print(" .");
					}
				}
				System.out.println();
				strs[index++] = sb.toString();
				sb.delete(0, sb.length());
			}
//			System.out.println(Arrays.toString(strs));
			result.add(strs);
			return;
		} else{
			
			//对第i行进行探测，在第j列放置合适的棋子
			for (int j=0; j<n; ++j){
				if (columns[j] == 0 && rUlD[row+j] == 0 && lUrD[row-j + n - 1] == 0){
					results[row] = j;
					columns[row] = rUlD[row+j] = lUrD[row-j + n - 1] = 1;
					trail(row+1, n, result);
					//撤销操作
					columns[row] = rUlD[row+j] = lUrD[row-j + n - 1] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Queens q = new Queens();
		q.solveNQueens(2);
	}
}
