/**
 * 文件名：RemoveNode.java
 * 所在包：leetcode
 * 日期：2014-10-28 下午7:25:37
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：RemoveNode
 * 类描述：
 * 创建人：黄传聪
 * 创建时间：2014-10-28 下午7:25:37
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RemoveNode {

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
	
	/**
	 * 方法名称：removeNthFromEnd()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
        
		if (head == null || n<0){
			return null;
		}
		ListNode tempHead = new ListNode(-1);
		tempHead.next = head;
		ListNode pre = tempHead;
		ListNode cur = tempHead;
		for (int i=0; i<n; ++i){
			
			pre = pre.next;
//			if (pre == null){
//				return null;
//			}
		}
		
		while (pre.next != null){
			pre = pre.next;
			cur = cur.next;
		}
		ListNode p = cur.next;
		cur.next = p.next;
		p = null;
		return tempHead.next;
    }

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
		next = null;
	}
}