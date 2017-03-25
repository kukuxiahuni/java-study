package Plus.One;

import java.util.Arrays;

public class Solution {
    
    public static int[] plusOne(int[] digits) {
        
    	int length = digits.length;
        int carry = 0;
        for(int i=length-1;i>=0;--i){
        	
            int temp = digits[i] + carry;
            if(i == length-1){
            	temp += 1;
            }
            digits[i] = temp % 10;
            carry = temp / 10;
        }
        
        if(carry > 0){
            int[] result = new int[digits.length + 1];
            result[0] = carry;
            System.arraycopy(digits, 0, result, 1, length);
            return result;
        }
        
        return digits;
    }
    
    public static void main(String[] args) {
		int[] digits = {9};
		int[] result = plusOne(digits);
		System.out.println(Arrays.toString(result));
	}
}