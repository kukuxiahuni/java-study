/**
 * 文件名：BTree.java
 * 所在包：SearchLearning
 * 日期：2014-3-12 上午11:26:02
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package SearchLearning;

import java.util.Arrays;

/**
 *
 * 项目名称：data_structure
 * 类名称：BTree
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-3-12 上午11:26:02
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class BTree {

	/**  树的度  */    
	private int degree;
	/**  树的根节点  */    
	private Node root;
	
	
	
	public BTree(int degree) {
		this.degree = degree;
		root = new Node(degree);
	}
	/**
	 *
	 * 项目名称：data_structure
	 * 类名称：node
	 * 类描述：B 树节点
	 * 创建人：黄传聪
	 * 创建时间：2014-3-12 上午11:34:26
	 * 修改人：
	 * 修改时间：
	 * 修改备注：
	 * @version
	 */
	private final class Node{
		/** 说明关键字的数量   */    
		public int nums;
		/**  关键字数组 , 长度为nums + 1 其中0 位置不存 */    
		public int[] keys;
		/**  指针数组  */    
		public Node[] nexts;
		
		/**  指向父节点的指针  */    
		public Node parent;
		/**  在关键字磁盘中的位置  */    
		public int[] offset;
		
		/**  默认为叶子节点  */    
		private boolean isLeaf;

		public Node(int nums) {
			this.nums = nums;
			this.keys = new int[nums + 1];
			this.nexts = new Node[nums + 1];
			this.offset = new int[nums];
			this.parent = null;
			this.isLeaf = true;
		}
	}
	
	public int search(Node root, int key){
		if(root != null){
			int index = Arrays.binarySearch(root.keys, key);
			if(index > 0){
				//找到
				return root.offset[index-1];
			}else{
				index += 2;
				//获取 下个指针的索引
				index = Math.abs(index);
				search(root.nexts[index], key);
			}
		}
		//查找失败
		return -1;
	}
	
	
	/**
	 * 方法名称：insert()
	 * 方法描述：向节点中插入数据,注意会有分裂的情形
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void insert(int key){
		
	}
	public static void main(String[] args){
		int[] a = {1,2,3,5};
		
		int index = Arrays.binarySearch(a, 4);
		System.out.println(index);
	}
}
