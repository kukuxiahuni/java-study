/**
 * 文件名：MinimumPath.java
 * 所在包：leetcode
 * 日期：2014-9-9 下午9:03:32
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;


/**
 *
 * 项目名称：LeetCode
 * 类名称：MinimumPath
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-9-9 下午9:03:32
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MinimumPath {

	 public int minPathSum(int[][] grid) {
	        
	        int m = grid.length;
	        int n = grid[0].length;
	        int[][] results = new int[m][n];
//	        Arrays.fill(results, Integer.MIN_VALUE);
	        return dfs(grid, m-1, n-1, results);
	        
	    }
	    
	    private int dfs(int[][] grid, int i, int j, int[][] results){
	    	
	    	if (i<0 || j<0){
	    		return Integer.MAX_VALUE;
	    	}
	    	
	    	if (i==0 && j==0){
	    		return grid[i][j];
	    	}
	    	
	    	return Math.min(getOrUpdate(grid,i-1,j,results), getOrUpdate(grid,i,j-1,results)) + grid[i][j];
	    }
	    
	    private int getOrUpdate(int[][] grid, int i, int j, int[][] results){
	    	
	    	if (i<0 || j<0){
	    		return Integer.MAX_VALUE;
	    	}
	    	
	    	if (results[i][j] > 0){
	    		
	    		return results[i][j];
	    	} else {
	    		return results[i][j]=dfs(grid, i,j,results);
	    	}
	    	
	    }
	    
	    private int getResultByDp(int[][] grid){
	    	
	    	 int m = grid.length;
		     int n = grid[0].length;
		     int[][] results = new int[m][n]; 
		     
		     results[0][0] = grid[0][0];
		     
		     for (int i=1; i<m; ++i){
		    	 results[i][0] = results[i-1][0] + grid[i][0];
		     }
		     
		     for (int i=1; i<n; ++i){
		    	 
		    	 results[0][i] = results[0][i-1] + grid[0][i];
		     }
		     
		     for (int i=1; i<m; ++i){
		    	 for (int j=1; j<n; ++j){
		    		 results[i][j] = Math.min(results[i-1][j], results[i][j-1]) + grid[i][j];
		    	 }
		     }
		     
		     return results[m-1][n-1];
	    }
	    public static void main(String[] args) {
			MinimumPath path = new MinimumPath();
			int[][] A = {
					{1,2,2},
					{1,1,3}
			};
			
			System.out.println(path.minPathSum(A));
			System.out.println(path.getResultByDp(A));
		}
}
