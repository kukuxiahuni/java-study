/**
 * 文件名：Main.java
 * 所在包：jobdu1518
 * 日期：2014-10-14 下午1:00:53
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1518;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main
 * 类描述：反转链表
 * 创建人：黄传聪
 * 创建时间：2014-10-14 下午1:00:53
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main {

	static class ListNode {
		int val;
		ListNode next;
		
		public ListNode (int val){
			this.val = val;
			this.next = null;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int n = scanner.nextInt();
			
			if (n <= 0){
				System.out.println("NULL");
			} else {
				ListNode head = new ListNode(scanner.nextInt());
				
				ListNode p = head;
				for (int i=1; i<n; ++i){
					ListNode node = new ListNode(scanner.nextInt());
					p.next = node;
					p = p.next;
				}
				
				ListNode reverseNode = reverse(head);
				
				p = reverseNode;
				
				while (p != null){
					
					if (p.next == null){
						System.out.println(p.val);
					} else{
						System.out.print(p.val + " ");
					}
					p = p.next;
					
				}
			}
		}
	}
	public static ListNode reverse( ListNode head){
		
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode reverseHead = null;
		ListNode cur = head;
		ListNode pre = null;
		
		while (cur != null){
			
			ListNode next = cur.next;
			
			if (next == null){
				reverseHead = cur;
			}
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		
		
		return reverseHead;
		
		
	}
}
