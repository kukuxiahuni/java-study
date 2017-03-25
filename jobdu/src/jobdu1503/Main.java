/*
 * 项目名：应用支撑平台 jobdu
 * 包名：jobdu1503
 * 文件名：Main.java
 * 版本信息：1.0 v
 * 日期：2014年10月15日-下午5:00:24
 * Copyright (c) 航天科工智慧产业城市-系统工程事业部版权所有
 */
package jobdu1503;


	
/**
 * 类名称： Main
 * 类描述：
 * 创建人：黄传聪
 * 2014年10月15日 下午5:00:24
 * @version 1.0.0
 */
public class Main {

	/**方法描述：
	 * 方法名：main
	 * @param args void
	 * @author 黄传聪
	 * @exception 
	 * @date 2014年10月15日 下午5:00:24
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static TreeNode TreeNode(TreeNode root){
		
		TreeNode lastNode = null;
		
		convertNode(root, lastNode);
		
		TreeNode head = lastNode;
		
		while (head!=null && head.left != null){
			head = head.left;
		}
		return head;
	}
	private static void convertNode(TreeNode root, TreeNode listHead){
		
		if (root == null){
			return;
		}
		
		TreeNode cur = root;
		
		if (root.left != null){
			convertNode(root.left, listHead);
		}
		
		cur.left = listHead;
		
		if (listHead != null){
			listHead.right = cur;
		}
		
		listHead = cur;
		
		if (cur.right != null){
			convertNode(root.left, listHead);
		}
		
		
	}
	

}

class TreeNode{
	
	int val;
	TreeNode left;
	TreeNode right;
}
