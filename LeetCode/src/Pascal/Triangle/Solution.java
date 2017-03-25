package Pascal.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<List<Integer>> generate(int numRows) {
    	
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if(numRows == 0){
    		return results;
    	}
        List<Integer> subResult = new ArrayList<Integer>();
        subResult.add(1);
        results.add(subResult);
        if(numRows == 1){
    		return results;
    	}
        subResult = new ArrayList<Integer>();
        subResult.add(1);
        subResult.add(1);
        results.add(subResult);
        if(numRows == 2){
    		return results;
    	}
        for(int i=2;i<numRows;++i){
            subResult = new ArrayList<Integer>();
            subResult.add(1);
            List<Integer> temp = results.get(i-1);
            for(int j=1;j<i;++j){
                subResult.add(temp.get(j) + temp.get(j-1));
            }
            subResult.add(1);
            
            results.add(subResult);
        }
        
        return results;
        
    }
    
    public static void main(String[] args) {
		Solution.generate(1);
	}
}