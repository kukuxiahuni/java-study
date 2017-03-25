package Climbing.Stairs;
public class Solution {
	
    public int climbStairs(int n) {
       if(n==1 || n==0){
           return 1;
       }
       
       return climbStairs(n-1) + climbStairs(n-2);
    }
    public int climbStairs2(int n) {
        
    	   int[] steps = new int[n+1];
           steps[0] = steps[1] = 1;
           for(int i=2;i<=n;i++){
               steps[i] = steps[i-1] + steps[i-2];
           }
           return steps[n];
     }
    
    public int climbStairs3(int n) {
    	
		if (n == 1) {
			return 1;
		}

		// 1, 1,2,3,5,8
		int last = 0;  
		int mid = 1;
		int first = 1;
		
		//let the stair from 2
		for (int i = 2; i <= n; i++) {
			last = mid + first;
			first = mid;
			mid = last;
		}
        return last;
  }
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.climbStairs(5));
		System.out.println(s.climbStairs2(5));
		System.out.println(s.climbStairs3(3));
	}
}