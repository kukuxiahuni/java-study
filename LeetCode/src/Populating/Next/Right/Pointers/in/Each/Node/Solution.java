package Populating.Next.Right.Pointers.in.Each.Node;
/**
 *
 * 项目名称：LeetCode
 * 类名称：Solution
 * 类描述：Populating Next Right Pointers in Each Node
 * 创建人：黄传聪,此法神妙
 * 创建时间：2014-8-2 下午9:41:27
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Solution {
	public void connect(TreeLinkNode root) {

		if (root == null) {
			return;
		}
		TreeLinkNode pre = root;
		TreeLinkNode cur = null;

		while (pre.left != null) {
			cur = pre;
			while (cur != null) {
				cur.left.next = cur.right;
				if (cur.next != null) {
					cur.right.next = cur.next.left;
				}

				cur = cur.left;
			}

			pre = pre.left;
		}
	}
	
	public void connect1(TreeLinkNode root) {

		
		if (root == null) {
			return;
		}
		TreeLinkNode pre = root;
		
	}
}

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;

	TreeLinkNode(int x) {
		val = x;
	}
}