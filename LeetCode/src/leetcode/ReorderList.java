/**
 * 文件名：ReorderList.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午5:53:32
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * 项目名称：LeetCode
 * 类名称：ReorderList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午5:53:32
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ReorderList {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1)
		, p = new ListNode(2); head.next = p;
//		, q = new ListNode(3);
//		head.next = p;
//		p.next = q;
//		q.next = new ListNode(4);
		reorder(head);
//		while (node != null){
//			System.out.println(node.val);
//			node = node.next;
//		}
//		reorderList(head);
		
	}
	/**
	 * 方法名称：reorderList()
	 * 方法描述：使用栈存储链表的后半部分
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void reorderList(ListNode head) {
	
		if (head == null || head.next == null){
			
			return;
		}
		Deque<ListNode> stack = new ArrayDeque<>();
		
		ListNode fast = head, slow = head;
		
		while (fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		while (slow != null){
			stack.push(slow);
			slow = slow.next;
		}
		
		fast = head;
		while (fast != null && !stack.isEmpty()){
			
			ListNode node = stack.pop();
			ListNode p = fast.next;
			node.next = p;
			fast.next = node;
			fast = p;
		}
		
		slow = head;
		while (slow != null){
			System.out.println(slow.val);
			slow = slow.next;
		}
	}
	
	/**
	 * 方法名称：reorder()
	 * 方法描述：采用链表逆置的手段
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static void reorder(ListNode head){
		
		if (head == null || head.next == null){
			return;
		}
		
		ListNode fast = head, slow = head;
		while (fast.next!=null && fast.next.next!=null){
			fast = fast.next.next;
			slow = slow.next;
		}
		
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		//链表逆置
		slow = reverse(slow);
		
		fast = head;
		
		while (fast != null && slow != null){
			
			ListNode p = fast.next;
			ListNode q = slow.next;
			slow.next = p;
			fast.next = slow;
			fast = p;
			slow = q;
		}
		
		slow = head;
		while (slow != null){
			System.out.println(slow.val);
			slow = slow.next;
		}
	}
	
	/**
	 * 方法名称：reverse()
	 * 方法描述：链表逆置
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static ListNode reverse(ListNode head){
		
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode pre = null, cur = head, lastHead = null;
		
		while (cur != null){
			
			ListNode p = cur.next;
			if (p == null){
				lastHead = cur;
			}
			cur.next = pre;
			pre = cur;
			cur = p;
		}
		
		return lastHead;
	}

}
