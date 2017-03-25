package zigzag;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-8-27 下午4:32:10
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<>();
        if(root == null){
            return results;
        }
        results.add(new ArrayList<Integer>());
        
        travel(root, 1, results, false);
        
        return results;
        
    }
    
    private void travel(TreeNode root, int level, List<List<Integer>> results, boolean flag){
        
        if(root == null){
            return;
        }
        
        if(level > results.size()){
        	
            if(flag){
            	Collections.reverse(results.get(results.size()-1));
            }
            results.add(new ArrayList<Integer>());
            
        }
        results.get(level-1).add(root.val);
        
        travel(root.left, level+1, results, !flag);
        travel(root.right, level+1, results, !flag);
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x; 
	}
}