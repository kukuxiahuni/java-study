/**
 * 文件名：InsertionSortList.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午10:48:24
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：InsertionSortList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午10:48:24
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class InsertionSortList {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2), p = new ListNode(1); head.next = p;
		
		ListNode q = insertionSortList(head);
		while (q != null){
			System.out.println(q.val);
			q = q.next;
		}
	}
	public static ListNode insertionSortList(ListNode head) {
        
		if (head==null || head.next==null){
			return head;
		}
		
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode p = head;
		
		
		while (p != null){
			
			int val = p.val;
			ListNode node = new ListNode(val);
			ListNode pre = null, cur = dummy;
			while (cur != null && cur.val <= val){
				pre = cur;
				cur = cur.next;
			}
			
			if (cur == null){
				pre.next = node;
			} else{
				node.next = pre.next;
				pre.next = node;
			}
			p = p.next;
		
		}
		
		return dummy.next;
    }
}
