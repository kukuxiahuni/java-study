/**
 * 文件名：LongestCommonSubString.java
 * 所在包：DP
 * 日期：2014-11-15 上午11:24:35
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package DP;

/**
 *
 * 项目名称：LeetCode
 * 类名称：LongestCommonSubString
 * 类描述：最长公共子序列
 * 创建人：黄传聪
 * 创建时间：2014-11-15 上午11:24:35
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class LongestCommonSubString {

	
	
	private static int getLength(String str, String nextStr){
		
		if (str==null || str.length()<=0 || nextStr==null || nextStr.length()<=0){
			return 0;
		}
		
		int strLength = str.length(), nextStrLength = nextStr.length();
		//其中results[i][j] 表示str中1-i， nextStr中1-j 这两个字符串中的公共子序列的长度
		int[][] results = new int[strLength+1][nextStrLength+1];
		
		int[][] paths = new int[strLength+1][nextStrLength+1];
		for (int i=0; i<strLength; ++i){
			for (int j=0; j<nextStrLength; ++j){
				
				if (str.charAt(i) == nextStr.charAt(j)){
					results[i+1][j+1] = results[i][j] + 1;
					paths[i+1][j+1] = 1;
				} else {
					
					if (results[i+1][j] > results[i][j+1]){
						results[i+1][j+1] = results[i+1][j];
						paths[i+1][j+1] = -1;
					} else {
						results[i+1][j+1] = results[i][j+1];
						paths[i+1][j+1] = 2;
					}
				}
			}
		}
		printPath(paths, strLength, nextStrLength, str);
		System.out.println();
		return results[strLength][nextStrLength];
		
	}
	
	
	
	/**
	 * 方法名称：printPath()
	 * 方法描述：打印出的路径是相反的
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void printPath(int[][] paths, int begin, int end, String str) {
		// TODO Auto-generated method stub
		if (begin==0 || end==0){
			return;
		}
		
		if (paths[begin][end] == 1){
			//找到一个相同的点
			System.out.print(str.charAt(begin-1));
			printPath(paths, begin-1, end-1, str);
		} else if (paths[begin][end] == 2){
			printPath(paths, begin, end-1, str);
		} else {
			printPath(paths, begin-1, end, str);
		}
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

		String str = "ABCBDAB", nextStr = "BDCABA";
		System.out.println(getLength(str, nextStr));
	}

}
