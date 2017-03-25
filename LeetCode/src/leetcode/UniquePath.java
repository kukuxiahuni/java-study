/**
 * 文件名：UniquePath.java
 * 所在包：leetcode
 * 日期：2014-10-26 下午10:01:29
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：UniquePath
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-26 下午10:01:29
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class UniquePath {

	private int[][] memo;
	
	/**
	 * 方法名称：countByDFS()
	 * 方法描述：采用深搜解决,(m,n) = (m-1,n) + (m, n-1)
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int countByDFS(int m, int n){
		if (m<1 || n<1){ //越界
			return 0;
		}
		
		if (m==1 && n==1){
			return 1;
		}
		
		return countByDFS(m-1, n) + countByDFS(m, n-1);
	}
	public int count(int m, int n){
		memo = new int[m+1][n+1];
		return countByDFSWithMemo(m, n);
	}
	private int countByDFSWithMemo(int m, int n){
		
		if (m<1 || n<1){ //越界
			return 0;
		}
		
		if (m==1 && n==1){
			return 1;
		}
		
		return getMemo(m-1, n) + getMemo(m, n-1);
	}
	private  int getMemo(int m, int n) {
		// TODO Auto-generated method stub
		if (m<1 || n<1){ //越界
			return 0;
		}
		
		if (memo[m][n] > 0){
			return memo[m][n];
		}
		
		return memo[m][n] = countByDFSWithMemo(m, n);
	}
	
	/**
	 * 方法名称：countWithDP()
	 * 方法描述：采用DP实现
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private int countWithDP(int m, int n){
		if (m<=0 || n<=0){
			return 0;
		}
		
		int[][] paths = new int[m][n];
		paths[0][0] = 1;
		
		for (int i=1; i<n; ++i){
			paths[0][i] = paths[0][i-1];
		}
		
		for (int i=1; i<m; ++i){
			paths[i][0] = paths[i-1][0];
		}
		for (int i=1; i<m; ++i){
			for (int j=1; j<n; ++j){
				paths[i][j] = paths[i-1][j] + paths[i][j-1];
			}
		}
		
		return paths[m-1][n-1];
		
	}

	
	/****************************************************************************/
	
	/**
	 * 此部分为leetcode Unique Paths II
	 */
	
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	    
		 if (obstacleGrid==null || obstacleGrid.length<=0){
			 return 0;
		 }
		 int m = obstacleGrid.length - 1, n = obstacleGrid[0].length - 1;
		 memo = new int[m+1][n+1];
		 return count(obstacleGrid, m, n);
	 }
	
	
	private int count(int[][] obstacleGrid, int m, int n) {
		// TODO Auto-generated method stub
		if (m<0 || n<0){
			return 0;
		}
		//剪枝
		if (obstacleGrid[m][n] == 1){
			return 0;
		}
		if (m==0 && n==0){
			return 1;
		}
		return getMemo(obstacleGrid, m-1, n) + getMemo(obstacleGrid, m, n-1);
	}
	
	private int getMemo(int[][] obstacleGrid, int m, int n){
		
		if (m<0 || n<0){
			return 0;
		}
		//剪枝
		if (obstacleGrid[m][n] == 1){
			return 0;
		}
		
		if (memo[m][n] > 0){
			return memo[m][n];
		}
		
		return memo[m][n] = count(obstacleGrid, m, n);
	}
	
	public int countWithDp(int[][] obstacleGrid){
		
		if (obstacleGrid==null || obstacleGrid.length<=0){
			return 0;
		}
		
		if (obstacleGrid[0]==null || obstacleGrid[0].length<=0){
			return 0;
		}
		
		int m = obstacleGrid.length, n = obstacleGrid[0].length;
		if (obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1){
			return 0;
		}
		int[][] results = new int[m][n];
		results[0][0] = 1;
		
		for (int i=1; i<n; ++i){
			if (obstacleGrid[0][i] != 1){
				results[0][i] = results[0][i-1];
			} else{
				results[0][i] = 0;
			}
		}
		
		for (int i=1; i<m; ++i){
			if (obstacleGrid[i][0] != 1){
				results[i][0] = results[i-1][0];
			} else{
				results[i][0] = 0;
			}
		}
		
		for (int i=1; i<m; ++i){
			for (int j=1; j<n; ++j){
				
				if (obstacleGrid[i][j] != 1){
					results[i][j] = results[i-1][j] + results[i][j-1];
				} else{
					results[i][j] = 0;
				}
			}
		}
		
		return results[m-1][n-1];
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

//		System.out.println(countByDFS(3,4));
		UniquePath path = new UniquePath();
//		System.out.println(path.count(3,4));
		System.out.println(path.countWithDP(3,4));
		int[][] obstacleGrid = 
		{
				{0,0,0,0},
				{0,1,0,0},
				{0,0,0,0}
				
		};
		
		System.out.println(path.uniquePathsWithObstacles(obstacleGrid));
		System.out.println(path.countWithDp(obstacleGrid));
	}

}
