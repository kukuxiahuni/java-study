package Merge.Sorted.Array;

import java.util.Arrays;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int k = m + n -1;
        int i = m - 1;
        int j = n - 1;
        while(i>=0 && j>=0){
        	if(A[i] > B[j]){
        		A[k--] = A[i--];
        	}else{
        		A[k--] = B[j--];
        	}
        }
        
        while(i>=0){
        	A[k--] = A[i--];
        }
        
        while(j>=0){
        	A[k--] = B[j--];
        }
        System.out.println(Arrays.toString(A));
    }
    public void merge1(int A[], int m, int B[], int n) {
    	System.arraycopy(B, 0, A, m, n);
    	Arrays.sort(A);
    	System.out.println(Arrays.toString(A));
    }
    public static void main(String[] args) {
		int[] A = new int[3];
		A[0] = 0;
		int[] B = {1,4};
		
		Solution s = new Solution();
		s.merge(A, 1, B, 2);	
		s.merge1(A, 1, B, 2);
	}
}