/**
 * 文件名：MatrixZeroes.java
 * 所在包：leetcode
 * 日期：2014-9-15 上午10:19:41
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
 * 类名称：MatrixZeroes
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-9-15 上午10:19:41
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MatrixZeroes {
	public void setZeroes(int[][] matrix) {
	      
        if (null == matrix){
            return ;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] changeTag = new int[m*n];
        Arrays.fill(changeTag, -1);
        
        for (int i=0; i<m; ++i){
            
            for (int j=0; j<n; ++j){
                if (matrix[i][j]  == 0){
                    changeTag[i*n + j] = j;
                }
            }
        }
        
//        System.out.println(Arrays.toString(changeTag));
        for (int i=0; i<m*n; ++i){
            
            if (changeTag[i] >=0){
            	int cloumn = changeTag[i];
            	int row = (i - cloumn) / n;
                Arrays.fill(matrix[row], 0);
                for (int j=0; j<m; ++j){
                    matrix[j][cloumn] = 0;
                }
            }
        }
        
//        for (int i=0; i<m; ++i){
//        	System.out.println(Arrays.toString(matrix[i]));
//        }
	}
	
	public void setZeroe(int[][] matrix){
		
		 int m = matrix.length;
	     int n = matrix[0].length;
	     
	     boolean[] rows = new boolean[m];
	     boolean[] colums = new boolean[n];
	     
	     for (int i=0; i<m; ++i){
	    	 for (int j=0; j<n; ++j){
	    		 if (matrix[i][j] == 0){
	    			 rows[i] = colums[j] = true;
	    		 }
	    	 }
	     }
	     
	     System.out.println(Arrays.toString(rows));
	     System.out.println(Arrays.toString(colums));
     
	     for (int i=0; i<m; ++i){
	    	 if (rows[i]){
	    		 Arrays.fill(matrix[i], 0);
	    	 }
	     }
	     
	     for (int j=0; j<n; ++j){
	    	 
	    	 if (colums[j]){
	    		 for (int i=0; i<m; ++i){
	    			 matrix[i][j] = 0;
	    		 }
	    	 }
	     }
	     
	     for (int i=0; i<m; ++i){
	    	 System.out.println(Arrays.toString(matrix[i]));
	     }
		
	}
	
	public static void main(String[] args) {
		
		MatrixZeroes zero = new MatrixZeroes();
		
		int[][] a = {
				{3,5,5,6,9,1,4,5,0,5},
				{2,7,9,5,9,5,4,9,6,8},
				{6,0,7,8,1,0,1,6,8,1},
				{7,2,6,5,8,5,6,5,0,6},
				{2,3,3,1,0,4,6,5,3,5},
				{5,9,7,3,8,8,5,1,4,3},
				{2,4,7,9,9,8,4,7,3,7},
				{3,5,2,8,8,2,2,4,9,8}
				
//				{1,2},
//				{0, 0}
		};
		
//		zero.setZeroes(a);
		zero.setZeroe(a);
	}
}
