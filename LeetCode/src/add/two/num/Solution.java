package add.two.num;

/**
 * Created by kukuxiahuni on 2018/3/1.
 */
public class Solution {

    public final static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            throw new IllegalArgumentException();
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(0);
        ListNode p = head;

        int pre = 0; //进位
        while (l1 != null && l2 != null) {
            p.next = new ListNode(0);
            p = p.next;
            int val = l1.val + l2.val + pre;
            pre = val / 10;
            val = val % 10;
            p.val = val;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 == null) {

            while (l2 != null) {
                p.next = new ListNode(0);
                p = p.next;
                int val = l2.val + pre;
                pre = val / 10;
                val = val % 10;
                p.val = val;

                l2 = l2.next;
            }

        }

        if (l2 == null) {

            while (l1 != null) {
                p.next = new ListNode(0);
                p = p.next;
                int val = l1.val + pre;
                pre = val / 10;
                val = val % 10;
                p.val = val;

                l1 = l1.next;
            }

        }

        if (pre > 0) {
            p.next = new ListNode(pre);
        }

        return head.next;
    }
}

