package Binary.Tree.preorder;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        TreeNode p = root;
//        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(p!=null || !stack.isEmpty()){
            while(p!= null){
                list.add(p.val);
                stack.push(p);
                p = p.left;
            }
            
            if(!stack.isEmpty()){
                p = stack.pop();
                p = p.right;
            }
        }
        
        return list;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }