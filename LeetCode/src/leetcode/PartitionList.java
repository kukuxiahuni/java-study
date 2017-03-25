/**
 * 文件名：PartitionList.java
 * 所在包：leetcode
 * 日期：2014-10-28 下午7:54:12
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：PartitionList
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-28 下午7:54:12
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class PartitionList {

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
		head.next = new ListNode(1);
		int x = 0;
		
		ListNode re = partition(head, x);
		while (re != null){
			System.out.println(re.val);
			re = re.next;
		}
	}
	
	 public static ListNode partition(ListNode head, int x) {
	        
		 if (head == null){
			 return head;
		 }
		 
		 ListNode pre = new ListNode(-1), post = new ListNode(-1), cur = head;
		 pre.next = head;
		 post.next = head;
		 ListNode p = pre, q = post;
		 while (cur != null){
			 if (cur.val <= x){
				 p.next = cur;
				 p = p.next;
			 } else{
				 q.next = cur;
				 q = q.next;
			 }
			 
			 cur = cur.next;
		 }
		 
		 p.next = post.next;
		 return pre.next;
	 }

}
