/**
 * 文件名：Median.java
 * 所在包：leetcode
 * 日期：2014-8-29 下午3:28:52
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
 * 类名称：Median
 * 类描述：Median of Two Sorted Arrays
 * There are two sorted arrays A and B of size m and n respectively. 
 * Find the median of the two sorted arrays. 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * 创建人：黄传聪
 * 创建时间：2014-8-29 下午3:28:52
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Median {

	
	 public double findMedianSortedArrays(int A[], int B[]) {
	    int[] c = new int[A.length + B.length];
	    
	    System.arraycopy(A, 0, c, 0, A.length);
	    System.arraycopy(B, 0, c, A.length, B.length);
	    
	    Arrays.sort(c);
	    
	    if(c.length % 2 == 0){
	    	return (c[c.length/2] + c[(c.length-1)/2])/2.0;
	    }else{
	    	return c[c.length/2]; 
	    }
//	    System.out.println(c.length);
//	    System.out.println(Arrays.toString(c));
//	    
	    
	 }
	 

	 /**
	 * 方法名称：findMedian()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public double findMedianByMergeSort(int A[], int B[]) {
	    
		int length = A.length + B.length;
		int mid = length >> 1;
		int i = 0, j= 0;
		int index = 0;
		int pre = 0, post = 0;
		while(i<A.length && j<B.length && index <= mid){
			
			if(A[i] < B[j]){
				
				++index;
				pre = post;
				post = A[i];
				++i;
			}else {
				
				++index;
				pre = post;
				post = B[j];
				++j;
			}
		}
		while(i<A.length && index <= mid){
			++index;
			pre = post;
			post = A[i];
			++i;
		}
		while(j<B.length && index <= mid){
			++index;
			pre = post;
			post = B[j];
			++j;
		}
		if((index==mid+1) &&((length&1)==1)){
			return post;//A.length<B.length ? pre:post;
		}else if((index==mid+1) &&((length&1)==0)){
			return (pre + post) / 2.0;
		}
	    return 0;
	 }
	
	/**
	 * 方法名称：findMedian()
	 * 方法描述：采用简便方法:未成功解决
	 * 参考：http://blog.csdn.net/yutianzuijin/article/details/11499917
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public double findMedian(int A[], int B[]) {
		
		int length = A.length + B.length;
		
		if ((length & 1) == 1){
			
			return findTopK(A, A.length, B, B.length, (length/2) + 1);
		} else{
			return (findTopK(A, A.length, B, B.length, length/2) + findTopK(A, A.length, B, B.length, (length/2)+1)) / 2.0;
		}
		
	}
	
	private double findTopK(int[] A, int m, int[] B, int n, int k){
		
		if (m > n){
			//保证 m<=n
			return findTopK(B, n, A, m, k);
		} 
		//注意最小数组为0的情形
		if (m == 0){
			return B[k-1];
		} 
		if (k == 1){
			return Math.min(A[0], B[0]);
		}
		
		//将k划分为两部分
		
		int pa = Math.min(k/2, m), pb = k - pa;
		
		if (A[pa-1] > B[pb-1]){
			
			B = Arrays.copyOfRange(B, pb, n);
			return findTopK(A, m, B, n-pb, k - pb);
			
		} else if (A[pa-1] < B[pb-1]){
			
			A = Arrays.copyOfRange(A, pa, m);
			return findTopK(A, m-pa, B, n, k - pa); 
			
		} else{
			
			return A[pa-1];
			
		}
		
	}
	
	public static void main(String[] args) {
		
	}
}
