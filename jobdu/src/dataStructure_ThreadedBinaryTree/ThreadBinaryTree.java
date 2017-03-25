/**
 * 文件名：ThreadBinaryTree.java
 * 所在包：dataStructure_ThreadedBinaryTree
 * 日期：2013-12-13 上午10:09:08
 * 版本信息：version V1.0
 * Copyright Corporation 2013
 * 版权所有: 
 *
 */  

package dataStructure_ThreadedBinaryTree;


/**
 *
 * 项目名称：jobdu
 * 类名称：ThreadBinaryTree
 * 类描述：进行中序线索化算法:该段代码参照百度百科中线索二叉树条目和《算法与数据结构-Java语言描述》线索二叉树部分完成
 * 创建人：黄传聪
 * 创建时间：2013-12-13 上午10:09:08
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ThreadBinaryTree <T>{

	//定义枚举类型
	enum Tags{
		link(0),
		thread(1);
		private int index;
		Tags(int index){
			this.index = index;
		}
		
	};
	private ThreadBinaryTree<T> lChild;
	private ThreadBinaryTree<T> rChild;
	private int lTag;
	private int rTag;
	private T data;
	
	public ThreadBinaryTree(ThreadBinaryTree<T> lChild, ThreadBinaryTree<T> rChild,
			int lTag, int rTag, T data) {
		this.lChild = lChild;
		this.rChild = rChild;
		this.lTag = lTag;
		this.rTag = rTag;
		this.data = data;
	}
	
	/**
	 * 方法名称：inOrderThread()
	 * 方法描述：采用中序方式生成线索二叉树
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	//节点的前序节点，初始化为null
	ThreadBinaryTree<T> pre = null;
	public void inOrderThread(ThreadBinaryTree<T> head){
		
		if(head != null){
			//对左子树进行线索化
			inOrderThread(head.lChild);
			//如果左孩子为空
			if(head.lChild == null){
				head.lTag = Tags.thread.index;
				head.lChild = pre;
			}
			//如果右孩子为空,线索化
			if(head.rChild == null){
				head.rTag = Tags.thread.index;
			}
			//前驱节点的右孩子为空,线索化，并设置后继节点
			if(pre != null && pre.rTag == Tags.thread.index){
				pre.rChild = head;
			}
			
		/*	head.lTag = (head.lChild == null) ? Tags.thread.index : Tags.link.index;
			head.rTag = (head.rChild == null) ? Tags.thread.index : Tags.link.index;
			if(pre != null){
				if(pre.rTag == Tags.thread.index){
					pre.rChild = head;
				}
				if(pre.lTag == Tags.link.index){
					head.lChild = pre;
				}
			}*/
			pre = head; //设置前驱节点
			inOrderThread(head.rChild);
			
		}
	}
	
	/**
	 * 方法名称：inOrderSuccessor()
	 * 方描述：中序查找p的后继节点
	 * 1. 如果p没有右孩子，则其为线索化，直接取到右孩子。
	 * 2. 有过p有右孩子——》则需遍历右子树，找到右子树的最左节点。
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public ThreadBinaryTree<T> inOrderSuccessor(ThreadBinaryTree<T> p){
		
		if(p != null){
			//如果p右子树为空
			if(p.rTag == Tags.thread.index){
				return p.rChild;
			}else{
				//遍历右子树
				ThreadBinaryTree<T> q = p.rChild;
				while(q.lTag == Tags.link.index){
					q = q.lChild;
				}
				return q;
			}
			
		}
		return null;
	}
	/**
	 * 方法名称：inOrderPre()
	 * 方法描述：中序查找前序节点
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public ThreadBinaryTree<T> inOrderPre(ThreadBinaryTree<T> p){
		
		if(p != null){
			//如果p右子树为空
			if(p.lTag == Tags.thread.index){
				return p.lChild;
			}else{
				//遍历左子树，寻找最右节点
				ThreadBinaryTree<T> q = p.lChild;
				while(q.rTag == Tags.link.index){
					q = q.rChild;
				}
				return q;
			}
			
		}
		return null;
	}
	
	/**
	 * 方法名称：traverseInOrder()
	 * 方法描述：中序遍历线索二叉树，其遍历的结果和对二叉树的中序遍历结果一致
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public void traverseInOrder(ThreadBinaryTree<T> p){
		
		if(p != null){
			//找到遍历的起始节点，也就是最左节点
			while(p.lTag == Tags.link.index){
				p = p.lChild;
			}
			
			do{
				System.out.println(p.data);//访问节点
				p = inOrderSuccessor(p);//查找p的中序后继
			}while(p != null);
		}
	}
	
}
