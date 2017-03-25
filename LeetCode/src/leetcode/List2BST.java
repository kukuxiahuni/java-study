/**
 * 文件名：List2BST.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午8:21:28
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：List2BST
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午8:21:28
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class List2BST {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		List2BST tree = new List2BST();
		tree.sortedListToBST(head);
	}
	
	 public TreeNode sortedListToBST(ListNode head) {
	        
		 if (head == null){
			 return null;
		 }
		 
		 //递归方式
		 //找到list的中间节点
		 int len = getLen(head);
		 return binaryTree(head, len);
	 }
	 
	 private int getLen(ListNode head){
		 
		 ListNode p = head;
		 int count = 0;
		 
		 while (p != null){
			 ++count;
			 p = p.next;
		 }
		 
		 return count;
	 }
	 
	 /**
	 * 方法名称：getNode()
	 * 方法描述：获取列表中第n个节点
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private ListNode getNode (ListNode head, int n){
	
		ListNode p = head;
		while (n > 0){
			
			p = p.next;
			--n;
		}
		
		return p;
		
	}
	
	private TreeNode binaryTree(ListNode head, int len){
		
		if (len == 0){
			return null;
		}
		
		if (len == 1){
			return new TreeNode(head.val);
		}
		
		TreeNode node = new TreeNode(getNode(head, len/2+1).val);
		
		node.left = binaryTree(head, len/2);
		node.right = binaryTree(getNode(head, len/2+2), len/2-1);
		
		return node;
	}

}

class TreeNode {
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
}