/**
 * 文件名：BinarySortTree.java
 * 所在包：SearchLearning
 * 日期：2014-2-26 上午11:37:25
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package SearchLearning;

/**
 *
 * 项目名称：data_structure
 * 类名称：BinarySortTree
 * 类描述：二叉排序树
 * 创建人：黄传聪
 * 创建时间：2014-2-26 上午11:37:25
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class BinarySortTree {

	private int data;
	private BinarySortTree lChild;
	private BinarySortTree rChild;
	
	public BinarySortTree(int data){
		this.data = data;
		lChild = null;
		rChild = null;
	}
	
	public BinarySortTree(){
		this.data = 0;
		lChild = null;
		rChild = null;
	}
	
	
	/**
	 * 方法名称：createTree()
	 * 方法描述：根据数组中的数据信息生成一个二叉查找树
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public BinarySortTree createTree(int[] datas){
		BinarySortTree root = new BinarySortTree(datas[0]);
		for(int i=1;i<datas.length;i++){
			insertTree(root, datas[i]);
		}
		return root;
	}


	/**
	 * 方法名称：insertTree()
	 * 方法描述：向二叉排序树种插入数据
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private void insertTree(BinarySortTree root, int data) {
		// TODO Auto-generated method stub
		if(root == null){
			root = new BinarySortTree();
			root.data = data;
		}else{
			if(data < root.data){
				insertTree(root.lChild, data);
			}else if(data > root.data){
				insertTree(root.rChild, data);
			}else{
				return ;
			}
		}
	}
	
	/**
	 * 方法名称：inOrder()
	 * 方法描述：中序遍历
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void inOrder(BinarySortTree root){
		if(root != null){
			inOrder(root.lChild);
			System.out.print(root.data + " ");
			inOrder(root.rChild);
		}
	}
	
	/**
	 * 方法名称：search()
	 * 方法描述：查找元素
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public boolean search(BinarySortTree root, int data){
		if(root != null){
			if(root.data == data){
				return true;
			}else if(root.data < data){
				return search(root.rChild, data);
			}else {
				return search(root.lChild, data);
			}
		}
		return false;
	}
	
	/**
	 * 方法名称：delete()
	 * 方法描述：删除节点
	 * @param 采用递归的方式进行删除  
	 * @return String    
	 * @Exception 
	 */
	public void delete(BinarySortTree root, int data){
		
		if(root != null){
			if(root.data < data){
				//查找右孩子
				delete(root.rChild,data);
			}else if(root.data > data){
				delete(root.lChild,data);
			}else{
				deleteNode(root);
			}
		}
		
	}
	
	/**
	 * 方法名称：deleteNode()
	 * 方法描述：执行具体的删除操作
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private void deleteNode(BinarySortTree p) {
		// TODO Auto-generated method stub
		if(p != null){
			//如果节点有左子树
			/*1。若p有左子树，找到其左子树的最右边的结点r，用该叶子结点r来替代p，把r的左孩子
			作为r的父亲的右孩子。
			2。若p没有左子树，直接用p的右孩子取代它。*/
			if(p.lChild != null){
				BinarySortTree r = p.lChild;
				BinarySortTree prev = p.lChild;
				
				while(r.rChild != null){
					prev = r;
					r = r.rChild;
				}
				p.data = r.data;
				
				//若r不是p的左子树,p的左子树不变，r的左子树作为r的父节点的右孩子节点
				if(prev != r ){
					prev.rChild = r.lChild;
				}else{
					//若r是p的左子树，则p的左子树只想r的左子树
					p.lChild = r.lChild;
				}
			}else{
				p = p.rChild;
			}
		}
	}

	public static void main(String[] args){
		BinarySortTree root = new BinarySortTree();
		int[] datas = {14,9,17,16};//{63,90,70,55,67,42,98,83,10,45,58};
		root = root.createTree(datas);
		root.inOrder(root);
		System.out.println();
		System.out.println(root.search(root, 98));
		root.delete(root, 17);
		root.inOrder(root);
	}
	
}
