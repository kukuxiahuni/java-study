package Rotate.Image;

import java.util.Arrays;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-18 下午4:50:21
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    /**
     * 方法名称：rotate()
     * 方法描述：
     * @param  
     * @return String    
     * @Exception 
     */
    public static void rotate(int[][] matrix) {
        
    	//n*n the length = n
    	int length = matrix.length;
    	
    	for(int i=0; i<length/2; ++i){
    		for(int j=i; j<length-i-1; ++j){
    			int temp = matrix[i][j];
    			temp = swap(matrix, temp, j, length-i-1);
    			temp = swap(matrix, temp, length-i-1, length-j-1);
    			temp = swap(matrix, temp, length-j-1, i);
    			temp = swap(matrix, temp, i, j);
    		}
    	}
    	
    	for(int i=0; i<length; ++i){
    		System.out.println(Arrays.toString(matrix[i]));
    	}
    }
    
    private static int swap(int[][] m, int temp, int i, int j){
    	int retVal = m[i][j];
    	
    	m[i][j] = temp;
    	
    	return retVal;
    }
    
    
    
    public static void rotate2(int[][] matrix){
    	
    	int length = matrix.length;
    	//1. 按照主对角线交换
    	
    	for(int i=0; i<length-1; ++i){
    		for(int j=0; j<length-i-1; ++j){
    			int temp = matrix[i][j];
    			matrix[i][j] = matrix[length-j-1][length-i-1];
    			matrix[length-j-1][length-i-1] = temp; 
    		}
    	}
    	for(int i=0; i<length; ++i){
    		System.out.println(Arrays.toString(matrix[i]));
    	}
    	//2. 按照中间线交换
    	for(int i=0; i<length/2; ++i){
    		for(int j=0; j<length; ++j){
    			int temp = matrix[i][j];
    			
    			matrix[i][j] = matrix[length-i-1][j];
    			matrix[length-i-1][j] = temp;
    		}
    	}
    	System.out.println("**************************");
    	for(int i=0; i<length; ++i){
    		System.out.println(Arrays.toString(matrix[i]));
    	}
    }
    public static void main(String[] args) {
    	
    	int[][] matrix = {
    			
    			{1, 2, 3, 4},
    			{5, 6, 7, 8},
    			{9, 10,11,12},
    			{13,14,15,16}
    			
    	};
		rotate2(matrix);
	}
}