/**
 * 文件名：WordSearch.java
 * 所在包：leetcode
 * 日期：2014-10-26 下午9:11:52
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：WordSearch
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-26 下午9:11:52
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class WordSearch {

	public static  boolean exist(char[][] board, String word) {
        
		if (board==null || board.length<=0 || word==null || word.length()<=0){
			return false;
		}
		int m = board.length, n = board[0].length;
		boolean [][] visited = new boolean[m][n]; //用于指示i行j列是否被访问
		for (int i=0; i<m; ++i){
			for (int j=0; j<n; ++j){
				if (exist(board, word, 0, visited, i, j)){
					return true;
				}
			}
		}
		return false;
    }
	
	
	
	
	private static boolean exist(char[][] board, String word, int index, boolean [][] visited, int m, int n) {
		// TODO Auto-generated method stub
		if (index == word.length()){
			return true;
		} 
		
		if (m<0 || n<0 || m>=board.length || n>=board[0].length){
			return false;
		}
		
		if (word.charAt(index) != board[m][n]){
			return false;
		}
		if (visited[m][n]){
			return false;
		}
		//相等且未被访问
		visited[m][n] = true;
		boolean result = exist(board, word, index+1, visited, m-1, n) || exist(board, word, index+1, visited, m+1, n) ||
				exist(board, word, index+1, visited, m, n-1) || exist(board, word, index+1, visited, m, n+1);
		
		visited[m][n] = false;
		return result;
	}




	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		char[][] chs = 
			{
				{'A', 'B', 'C', 'E'},
				{'S', 'F', 'C', 'S'},
				{'A', 'D', 'E', 'E'}
			};
		
		String str = "ABCB";
		
		System.out.println(exist(chs, str));
	}

}
