/**
 * 文件名：RemoveDuplicates.java
 * 所在包：leetcode
 * 日期：2014-10-29 下午10:32:09
 * 版本信息：version V1.0
 * Copyright Corporation 2014
 * 版权所有: 
 *
 */  

package leetcode;

/**
 *
 * 项目名称：LeetCode
 * 类名称：RemoveDuplicates
 * 类描述：未实现
 * 创建人：黄传聪
 * 创建时间：2014-10-29 下午10:32:09
 * 修改人：
 * 修改时间：
 * 修改备注：
 * @version
 */
public class RemoveDuplicates {

	/**
	 * 方法名称：main()
	 * 方法描述：
	 * @param  
	 * @return String    
	 * @Exception 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode list = new ListNode(1), p = new ListNode(2), q = new ListNode(2);
		list.next = p;
		p.next = q;
		q.next = new ListNode(2);
		
		ListNode re = delete(list);
		while (re != null){
			System.out.println(re.val);
			re = re.next;
		}
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        
		if (head==null || head.next == null){
			return head;
		}
		
		ListNode p = head.next;
		
		if (head.val == p.val){
			
			while (p!=null && head.val == p.val){
				ListNode tem = p;
				p = p.next;
				tem = null;
			}
			
			return deleteDuplicates(p);
		} else{
			head.next = deleteDuplicates(head.next);
			return head;
		}
		
    }
	
	public  static ListNode delete(ListNode head){
		
		if (head==null || head.next==null){
			return head;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode p = head;
		
		while (p != null){
			
			boolean duplicate = false;
			while (p !=null && p.next!=null && p.val == p.next.val){
				ListNode tem = p.next;
				p = p.next;
				tem = null;
				duplicate = true;
			}
			
			if (duplicate){
				//删除最后一个p节点
				ListNode tem = p;
				p = p.next;
				tem = null;
				continue;
			}
			pre.next = p;
			pre = pre.next;
			p = p.next;
		}
		//这一句用来防止链表全部重复的情形和结尾的链表是重复的情形
		pre.next = p;
		return dummy.next;
	}

}
