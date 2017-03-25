import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int removeElement(int[] A, int elem) {
		 int length = A.length;
	        int index = 0;
	        for(int i=0;i<=length-1;++i){
	            if(A[i] != elem){
	                A[index++] = A[i];
	            }
	        }
		return index;
	}
	
	public int removeElement1(int[] A, int elem) {
		 int length = A.length;
	       
		 for(int i=0;i<length;++i){
			 if(A[i] == elem){
				 A[i] = A[length-1];
				 --length;
				 --i;
			 }
		 }
		 return length;
	}
	
	public static Set union(Set s1, Set s2){
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1};
		int elem = 1;
		s.removeElement(A, elem);
	}
}