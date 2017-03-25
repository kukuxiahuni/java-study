package Maximum.Depth.of.Binary.Tree;

/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：求解二叉树的最大深度
 * 创建人：黄传聪
 * 创建时间：2014-7-29 下午10:34:51
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		int m, n;
		if (root == null)
			return 0;
		m = maxDepth(root.left);
		n = maxDepth(root.right);
		return ((m > n) ? m : n) + 1;
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