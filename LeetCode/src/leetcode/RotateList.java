/**
 * 文件名：RotateList.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午9:21:06
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：RotateList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午9:21:06
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RotateList {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next = new ListNode(2);
		int k = 2;
		ListNode re = rotate(head, k);
		
		while (re != null){
			System.out.println(re.val);
			re = re.next;
		}
	}
	public static ListNode rotateRight(ListNode head, int n) {
	        
	    if (head==null || head.next==null || n<=0){
	       return head;
	    }
	    
	    ListNode dummy = new ListNode(-1);
	    dummy.next = head;
	    ListNode fast = dummy, slow = dummy;
	    for (int i=0; i<n; ++i){
	    	fast = fast.next;
	    }
	    
	    while (fast.next != null){
	    	fast = fast.next;
	    	slow = slow.next;
	    }
	    
	    ListNode node = slow.next;
	    slow.next = null;
	    
	    fast.next = head;
	    return node;
	    
	}
	
	private static ListNode rotate(ListNode head, int n){
		
		if (head==null || n==0){
			return head;
		}
		
		//求链表长度，并将指针指向链表的尾部
		int len = 1;
		ListNode p = head;
		while (p.next != null){
			++len;
			p = p.next;
		}
		//n可能会大于Len
		n = len - n % len;
		
		p.next = head;
		for (int i=0; i<n; ++i){
			p = p.next;
		}
		
		head = p.next;
		p.next = null;
		return head;
		
	}

}
