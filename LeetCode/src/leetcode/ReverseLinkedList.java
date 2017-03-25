/**
 * 文件名：ReverseLinkedList.java
 * 所在包：leetcode
 * 日期：2014-10-28 下午9:52:37
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：ReverseLinkedList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-28 下午9:52:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class ReverseLinkedList {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(3);
		head.next = new ListNode(5);
		
		ListNode node = reverseBetween(head, 2, 2);
		
		while (node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
	
	  public static ListNode reverseBetween(ListNode head, int m, int n) {
	        
	        if (head == null || m>n){
	            return head;
	        }
	        
	        ListNode tempHead = new ListNode(-1);
	        tempHead.next = head;
	        ListNode cur = null, pre = tempHead;
	        for (int i=0; i<m-1; ++i){
	        	pre = pre.next;
	        }
	        
	        ListNode temp = pre; //pre指针是固定不变的，永远指向已逆置数组的最后一个元素
	        pre = temp.next;
	        cur = pre.next;
	        for (int i=m; i<n; ++i){
	        	pre.next  = cur.next;
	        	cur.next = temp.next;
	        	temp.next = cur;
	        	cur = pre.next;
	        }
	        
	        return tempHead.next;
	        
	    }

}
