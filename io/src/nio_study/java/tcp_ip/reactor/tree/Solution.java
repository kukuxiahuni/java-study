package tcp_ip.reactor.tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here

        List<Integer> result = new ArrayList<>();

        if (root == null || k1 > k2) {
            return result;
        }

        //中序遍历二叉查找树，生成一个临时排序数组
        List<Integer> treeList = new ArrayList<>();

        for (int num : treeList) {
            if (num >= k1 && num <= k2) {
                result.add(num);
            }
        }


        return result;


    }

    public void inorder(TreeNode root, List<Integer> treeList) {

        if (root == null) {
            return;
        }

        inorder(root.left, treeList);
        treeList.add(root.val);
        inorder(root.right, treeList);

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(7);

        solution.searchRange(root, 6, 10);
    }
}


class TreeNode {
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}


