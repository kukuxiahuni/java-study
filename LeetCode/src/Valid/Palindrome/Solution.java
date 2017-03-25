package Valid.Palindrome;


public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null){
            return true;
        }
        
        s = s.toUpperCase().replaceAll("[^0-9a-zA-Z]", "");
        int begin = 0;
        int end = s.length() - 1;
        
        while(begin < end){
        	if(s.charAt(begin++) != s.charAt(end--)){
        		return false;
        	}
        }
        
        return true;
    }
    
    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isPalindrome("race a car"));
	}
}