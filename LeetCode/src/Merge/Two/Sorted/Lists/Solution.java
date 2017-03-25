package Merge.Two.Sorted.Lists;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
 }
 
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        if(l1 == null && l2 == null){
            return null;
        }
        
        if(l1 ==null && l2 != null){
            return l2;
        }
        
        if(l1 != null && l2 == null){
            return l1;
        }
        
        
        ListNode head = null;
       
        ListNode p = l1;
        ListNode q = l2;
        
        if(p.val < q.val){
            head = l1;
            p = p.next;
        }else{
            head = l2;
            q = q.next;
        }
        
         ListNode temp = head;
        while(p!=null && q != null){
            
            if(p.val < q.val){
                temp.next = p;
                p = p.next;
            }else{
                temp.next = q;
                q = q.next;
            }
        }
        
        while(p != null){
            temp.next = p;
            p = p.next;
            temp = temp.next;
        }
        
        while(q != null){
            temp.next = q;
            q = q.next;
            temp = temp.next;
        }
        
        
        return head;
    }
    
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    	
    	ListNode head = new ListNode(0);
    	
    	ListNode temp = head;
    	 ListNode p = l1;
         ListNode q = l2;
         while(p!=null && q != null){
             
             if(p.val < q.val){
                 temp.next = p;
                 p = p.next;
                 temp = temp.next;
             }else{
                 temp.next = q;
                 q = q.next;
                 temp = temp.next;
             }
         }
         
         while(p != null){
             temp.next = p;
             p = p.next;
             temp = temp.next;
         }
         
         while(q != null){
             temp.next = q;
             q = q.next;
             temp = temp.next;
         }
         
         
         return head.next;
    }
    
    public static void main(String[] args) {
    	ListNode l2 = new ListNode(5);
    	ListNode l1 = new ListNode(1);
    	ListNode node = new ListNode(2);
    	l1.next = node;
    	node.next = new ListNode(4);
    	
		Solution s = new Solution();
		ListNode head = s.mergeTwoLists1(l1, l2);
		System.out.println();
		
	}
}