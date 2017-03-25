/**
 * 文件名：SortList.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午4:27:58
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：SortList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午4:27:58
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class SortList {

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
		ListNode p = new ListNode(2);
		head.next = p;
		p.next = new ListNode(4);
		
		ListNode re = sortList(head);
		
		while (re != null){
			System.out.println(re.val);
			re = re.next;
		}
	}
	
	 /**
	 * 方法名称：sortList()
	 * 方法描述：链表排序
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static ListNode sortList(ListNode head) {
		
		if (head == null || head.next == null){
			return head;
		}
		
		ListNode fast = head, slow = head;
		
		while (fast.next != null && fast.next.next != null){
			
			fast = fast.next.next;
			slow = slow.next;
		}
		
		//从slow处断开链接
		fast = slow;
		slow = slow.next;
		fast.next = null;
		
		ListNode l1 = sortList(head), l2 = sortList(slow);
		
		return mergeSort(l1, l2);
		
	        
	 }

	/**
	 * 方法名称：sort()
	 * 方法描述：采用迭代方式
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private  static ListNode sort(ListNode head, ListNode slow) {
		// TODO Auto-generated method stub
		ListNode dummy = new ListNode(-1);
		for (ListNode p=dummy; head!=null || slow!=null; p=p.next){
			int fv = head == null ? Integer.MAX_VALUE : head.val;
			int sv = slow == null ? Integer.MAX_VALUE : slow.val;
			
			if (fv <= sv){
				p.next = head;
				head = head.next;
			} else{
				p.next = slow;
				slow = slow.next;
			}
		}
		return dummy.next;
	}
	
	/**
	 * 方法名称：mergeSort()
	 * 方法描述：采用递归方式，此种方式在leetcode导致栈溢出
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	private static ListNode mergeSort(ListNode head, ListNode slow){
		
		if (head == null){
			return slow;
		}
		
		if (slow == null){
			return head;
		}
		
		ListNode h = null;
		
		if (head.val <= slow.val){
			h = head;
			h.next = mergeSort(head.next, slow);
		} else{
			h = slow;
			h.next = mergeSort(head, slow.next);
		}
		
		return h;
	}
}
