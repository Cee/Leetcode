/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) { return head; }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        
        ListNode l = sortList(head);
        ListNode r = sortList(slow);
        
        return merge(l, r);
    }
    
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                head.next = l;
                l = l.next;
            } else {
                head.next = r;
                r = r.next;
            }
            head = head.next;
        }
        while (l != null) {
            head.next = l;
            l = l.next;
            head = head.next;
        }
        while (r != null) {
            head.next = r;
            r = r.next;
            head = head.next;
        }
        return dummy.next;
    }
}