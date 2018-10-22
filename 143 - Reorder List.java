/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) { return; }
        ListNode p = head;
        ListNode q = head.next;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        q = p.next;
        p.next = null;
        
        ListNode dummy = new ListNode(0);
        ListNode c = dummy;
        p = head;
        q = reverse(q);
        while (p != null) {
            c.next = p;
            p = p.next;
            c = c.next;
            if (q != null) {
                c.next = q;
                q = q.next;
                c = c.next;
            }
        }
        head = dummy.next;
    }
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}