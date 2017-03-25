/**
 * 文件名：Main.java
 * 所在包：jobdu1520
 * 日期：2014-10-14 下午2:53:28
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1520;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：树的子结构
 * 创建人：黄传聪
 * 创建时间：2014-10-14 下午2:53:28
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
	
	/**
	 * 方法名称：hasSubtree()
	 * 方法描述：先检索父节点，采用前序遍历
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public boolean hasSubtree(TreeNode parent, TreeNode child){
		
		if (child == null || parent == null){
			return false;
		}
		boolean result = false;
		if (parent.value == child.value){
			result = isSbuTree(parent, child);
		} else if (!result ){
			//查找左子树
			result = hasSubtree(parent.left, child);
		} else if (!result ){
			//查找右子树
			result = hasSubtree(parent.right, child);
		}
		
		return result;
	}

	private boolean isSbuTree(TreeNode parent, TreeNode child) {
		// TODO Auto-generated method stub
		if (child == null || parent == null){
			return false;
		}
		
		if (child.value != parent.value) return false;
		return isSbuTree(parent.left, child.left) && isSbuTree(parent.right, child.right);
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
