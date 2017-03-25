package Maximum.Subarray;

/**
 * 
 * 项目名称：LeetCode 类名称：Solution 类描述： 创建人：黄传聪 创建时间：2014-8-6 上午10:27:34 修改人： 修改时间：
 * 修改备注：
 * 
 * @version
 */
public class Solution {
	/**
	 * 方法名称：maxSubArray() 方法描述：最大子段和的普通解法
	 * 暴力求解法：i和j指定一段数据的闭区间[i,j]，然后计算该区间中的数据和
	 * @param
	 * @return String
	 * @Exception
	 */
	public int maxSubArray(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		int max = A[0];

		//i和j确定待计算的闭区间
		for (int i = 0; i < A.length; ++i) {
			for (int j = i; j < A.length; ++j) {
				// 计算i..j之间的值
				int subMax = 0;
				for (int k = i; k <= j; ++k) {
					subMax += A[k];
				}

				if (subMax > max) {
					max = subMax;
				}
			}

		}

		return max;
	}

	/**
	 * 方法名称：maxSubArray11()
	 * 方法描述：对上层方法改进
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public int maxSubArray11(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		int max = A[0];

		//i和j确定待计算的闭区间
		for (int i = 0; i < A.length; ++i) {
			int subMax =  0;
			for (int j = i; j < A.length; ++j) {
				// 计算i..j之间的值
				/*
				 * 在上层的计算过程中，[i,j]之间的值求解时，重复性高。如[1,3],须计算a1+a2+a3,但是a1+a2都已经计算过
				 * 此处，使用subMax表示[i,j-1]值，则s[j]=subMax+a[j]
				 * 
				 */
				subMax += A[j];
				if (subMax > max) {
					max = subMax;
				}
			}

		}

		return max;
	}

	/**
	 * 方法名称：maxSubArray1()
	 * 方法描述：方法1的改进，由于a1+a2+..ai = Si, 则 ai + a(i+1) +..+aj = Sj - S(i-1)
	 * @param 参考算法竞赛入门经典p140
	 * 1. 求出[0,i] 0<=i<=a.length，存放在数组sums中；
	 * 2. 求解各个字段之间的和。如sum[i,j] = Sj - S(i-1)
	 * @return String    
	 * @Exception 
	 */
	public int maxSubArray1(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		int[] sums = new int[A.length+1];
		sums[0] = 0;
		//sums中的数值，具体从下标1开始
		for (int i = 1; i <= A.length; ++i) {
			sums[i] = sums[i - 1] + A[i-1];
		}
		
		int max = A[0];
		//求解各个子段的和，并与最大值进行对比
		for (int i = 1; i <= A.length; ++i) {
			for (int j = i; j <= A.length; ++j) {
				int best;
				if ((best = sums[j] - sums[i-1]) > max) {
					max = best;
				}
			}
		}

		return max;
	}

	/**
	 * 方法名称：maxSubArray2()
	 * 方法描述：采用动态规划方式
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public int maxSubArray2(int[] A) {
		if (A.length == 1) {
			return A[0];
		}
		
		int max  = A[0];
		int b = 0;
		
		for(int i=0;i<A.length;++i){
			if( b > 0){
				b += A[i];
			}else{
				b = A[i];
			}
			
			if(b > max){
				max = b;
			}
			
		}
		
		return max;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = { 2, 1 };
		System.out.println(s.maxSubArray11(A));
	}
}