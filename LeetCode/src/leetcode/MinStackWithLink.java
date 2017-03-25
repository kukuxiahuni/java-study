/**
 * 文件名：MinStackWithLink.java
 * 所在包：leetcode
 * 日期：2014-11-12 下午8:11:05
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：MinStackWithLink
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-11-12 下午8:11:05
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class MinStackWithLink {

	class Node{
		int val;
		int min;
		Node next = null;
		
		public Node(){
			
		}
		
		public Node(int val){
			this.val = val;
			next = null;
		}
	}
	
	private Node head = null;
	
	public void push(int x){
		
		Node node = new Node(x);
		if (head == null){
			head = node;
			head.min = x;
		} else {
			node.next = head;
			head = node;
			head.min = Math.min(head.next.min, x);
		}
	}
	
	public void pop(){
		
		if (head==null){
			throw new NullPointerException();
		}
		
		Node p = head;
		head = head.next;
		p = null;
		
	}
	
	public int top(){
		if (head==null){
			throw new NullPointerException();
		}
		
		return head.val;
	}
	
	public int getMin(){
		if (head==null){
			throw new NullPointerException();
		}
		
		return head.min;
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

	}

}
