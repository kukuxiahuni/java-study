package DP;

/**
 *
 * 项目名称：LeetCode
 * 类名称：MartixLink
 * 类描述：动态规划实现矩阵链乘法
 * 创建人：黄传聪
 * 创建时间：2014-11-13 上午11:17:34
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MartixLink {

	/**
	 * 方法名称：getChainOrder()
	 * 方法描述：给定矩阵维度数组，求最佳分割方式
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static int getChainOrder(int[] array){
		
		if (array==null || array.length<=0){
			return -1;
		}
//		注意矩阵链长度要比维数数组长度小1
		int len = array.length-1;
		int[][] length = new int[len+1][len+1];
		int[][] results = new int[len+1][len+1];
		
		//对角线位置设置为0,表示自身到自身为0，也就是长度为1的情形
		for (int i=1; i<=len; ++i){
			length[i][i] = 0;
		}
		//长度为2-长度为Len-1，
		for (int l=2; l<=len; ++l){
			
			for (int i=1; i<=len-l+1; ++i){
				int j = i + l - 1;
				length[i][j] = Integer.MAX_VALUE;
				
				for (int k=i; k<j; ++k){
					int min = length[i][k] + length[k+1][j] + array[i-1] * array[k] * array[j];
					if (min < length[i][j]){
						length[i][j] = min;
						results[i][j] = k;
					}
				}
			}
		}
		
		print(results, 1, len);
		return length[1][len];
		
	}
	
	private static void print(int[][] length, int i, int j) {
		// TODO Auto-generated method stub
		if (i == j){
			System.out.print("A" + i) ;
		} else {
			System.out.print("( ");
			print(length, i, length[i][j]);
			print(length, length[i][j] + 1, j);
			System.out.print(" )");
		}
	}
	
	/**
	 * 方法名称：getChainOrder()
	 * 方法描述：递归方式求解
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private int getChainOrder(int[] array, int begin, int end, int[][] results){
		
		if (begin == end){
			return 0;
		}
		
		results[begin][end] = Integer.MAX_VALUE;
		
		for (int i=begin; i<end; ++i){
			int val = getChainOrder(array, begin, i, results) + getChainOrder(array, i+1, end, results);
			if (val < results[begin][end]){
				results[begin][end] = val;
			}
		}
		
		return results[begin][end];
	}
	
	
	/**
	 * 方法名称：getChainOrderWithMemo()
	 * 方法描述：采用备忘录方式,备忘录方式是一种自顶向下的填充方式，动态规划是自底向上的填充方式
	 * @param  results: 备忘录表，初始化时应该填充为Integer.MAXVALUE
	 * @return String    
	 * @Exception 
	 */
	private int getChainOrderWithMemo(int[] array, int begin, int end, int[][] results){
		
		if (begin == end){
			return results[begin][end] = 0;
		}
		
		if (results[begin][end] < Integer.MAX_VALUE){
			return results[begin][end];
		}
		
		for (int k=begin; k<end; ++k){
			
			int val = getChainOrderWithMemo(array, begin, k, results) + getChainOrderWithMemo(array, k+1, end, results);
			if (val < results[begin][end]){
				results[begin][end] = val;
			}
		}
		
		return results[begin][end];
	}

	public static void main(String[] args) {
		
		int[] array = {30,35,15,5,10,20,25};
		System.out.println(getChainOrder(array));
	}
}
