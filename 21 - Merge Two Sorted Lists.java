/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0); // dummy
        ListNode l = head;
        
        ListNode p = l1;
        ListNode q = l2;
        while (p != null && q != null) {
            int v1 = p.val;
            int v2 = q.val;
            if (v1 < v2) {
                l.next = p;
                p = p.next;
            } else {
                l.next = q;
                q = q.next;
            }
            
            l = l.next;
        }
        while (p != null) {
            l.next = p;
            p = p.next;
            l = l.next;
        }
        while (q != null) {
            l.next = q;
            q = q.next;
            l = l.next;
        }
        return head.next;
    }
}