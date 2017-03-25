/**
 * 文件名：CopyList.java
 * 所在包：leetcode
 * 日期：2014-11-12 下午9:46:05
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：CopyList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-12 下午9:46:05
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class CopyList {

	static class RandomListNode {
		 int label;
		 RandomListNode next, random;
		 RandomListNode(int x) { this.label = x; }
	}
	public  RandomListNode copyRandomList(RandomListNode head) {
		
		if (head==null){
			return head;
		}
		
		RandomListNode p = head.next, dummy = new RandomListNode(head.label), q = dummy;
		
		//复制节点
		while (p != null){
			q.next = new RandomListNode(p.label);
			q = q.next;
			p = p.next;
		}
	    
		//复制节点的Random指针
		
		p = head;
		q = dummy;
		while (p != null && q !=null){
			
			if (p.random != null){
				RandomListNode n = dummy;
				while (n!=null && n.label!=p.random.label){
					n = n.next;
				}
				
				q.random = n;
			}
			
			p = p.next;
			q = q.next;
		}
		
		return dummy;
	}
	
	private RandomListNode copy (RandomListNode head){
		if (head==null){
			return head;
		}
		
		//复制节点，并将复制的节点挂在原始节点的后面
		
		RandomListNode p = head;
		
		while (p != null){
			
			RandomListNode node = new RandomListNode(p.label);
			node.next = p.next;
			p.next = node;
			p = node.next;
		}
		
		//复制随机指针
		
		p = head;
		while (p!=null && p.next!=null){
			if (p.random != null){
				p.next.random = p.random.next;
			}
			
			p = p.next.next;
		}
		
		//拆分链表
		p = head;
		RandomListNode dummy = new RandomListNode(-1), q = dummy;
		
		while (p != null ){
			RandomListNode temp = p.next;
			p.next = temp.next;
			p = p.next;
			q.next = temp;
			q = q.next;
			temp.next = null;
			
		}
		
		return dummy.next;
	}
	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomListNode head = new RandomListNode(-1);
		CopyList copy = new CopyList();
		RandomListNode result = copy.copyRandomList(head);
		while (result != null){
			System.out.println(result.label);
			result = result.next;
		}
	}
	
	
	

}
