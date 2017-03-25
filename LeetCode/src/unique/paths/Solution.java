package unique.paths;
/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-20 下午4:53:23
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
	
    /**
     * 方法名称：uniquePaths()
     * 方法描述：
     * @param  
     * @return String    
     * @Exception 
     */
    public int uniquePaths(int m, int n) {
        
    	int count = 0;
    	
//    	if(int i=0; i<m; ++i){
//    		for(int j=0; j<n; ++j){
//    			
//    		}
//    	}
    	int x = 5;
    	x = x + (x++) + (++x) + (++x);
    	System.out.println(x);
    	return 1;
    }
    
    public static void main(String[] args) {
    	int x = 5;
    	x = x + x++ + ++x;
    	x = 0;
    	int y = 1;
    	y = x + y++;
    	System.out.println(y);
	}
}