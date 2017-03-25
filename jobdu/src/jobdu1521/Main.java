/**
 * 文件名：Main.java
 * 所在包：jobdu1521
 * 日期：2014-10-14 下午3:04:20
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1521;


/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：二叉树的镜像
 * 创建人：黄传聪
 * 创建时间：2014-10-14 下午3:04:20
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private static void mirror(TreeNode root){
		
		if (root == null){
			throw new IllegalArgumentException("二叉树为空");
		}
		
		//叶子节点，返回条件
		if (root.left == null && root.right == null){
			return;
		}
		
		//交换该节点的子节点
		TreeNode node = root.left;
		root.left = root.right;
		root.right = node;
		
		//对左右子树进行递归
		
		if (root.left != null){
			mirror(root.left);
		}
		
		if (root.right != null){
			mirror(root.right);
		}
	}

}

class TreeNode {
	
	int value;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(){}
	public TreeNode(int val){
		this.value = val;
		this.left = null;
		this.right = null;
	}
}
