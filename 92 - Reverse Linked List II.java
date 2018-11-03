/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) { return head; }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode p = dummy;
        for (int i = 1; i < m; i++) { p = p.next; }
        ListNode q = p.next;
        ListNode prev = null;
        ListNode curr = p.next;
        int count = n - m + 1;
        while (count > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count -= 1;
        }
        p.next = prev;
        q.next = curr;
        return dummy.next;
    }
}