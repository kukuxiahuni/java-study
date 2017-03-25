/**
 * 文件名：Main2.java
 * 所在包：jobdu1519
 * 日期：2014-10-14 下午2:36:05
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package jobdu1519;

import java.util.Scanner;

/**
 *
 * 项目名称：jobdu
 * 类名称：Main2
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-14 下午2:36:05
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class Main2 {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		
		while (scanner.hasNext()){
			
			int m = scanner.nextInt();
			int n = scanner.nextInt();
			
			if (m == 0 && n == 0){
				System.out.println("NULL");
			} else {
				ListNode first = new ListNode(scanner.nextInt());
				ListNode p = first;
				for (int i=1; i<m; ++i){
					p.next = new ListNode(scanner.nextInt());
					p = p.next;
				}
				
				ListNode second = new ListNode(scanner.nextInt());
				p = second;
				
				for (int i=1; i<n; ++i){
					p.next = new ListNode(scanner.nextInt());
					p = p.next;
				}
				
				ListNode head = combine(first, second);
				
				p = head;
				while (p != null){
					
					if (p.next == null){
						System.out.println(p.val);
						
					} else {
						System.out.print(p.val + " ");
					}
					p = p.next;
				}
			}
		}
	}
	
	private static ListNode combine(ListNode first, ListNode second){
		
		if (first == null){
			return second;
		}
		
		if (second == null){
			return first;
		}
		
		ListNode head = null;
		
		if (first.val < second.val){
			head = first;
			head.next = combine(first.next, second);
		} else {
			head = second;
			head.next = combine(first, second.next);
		}
		
		return head;
	}

}


class ListNode {
	
	int val;
	ListNode next;
	
	public ListNode(int val){
		this.val = val;
		this.next = null;
	}
}