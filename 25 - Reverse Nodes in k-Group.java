/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode s = dummy;
        while (head != null) {
            ListNode p = head;
            ListNode q = new ListNode(0);
            int n = k;
            while (n > 0 && head != null) {
                q.next = head;
                q = q.next;
                head = head.next;
                n--;
            }
            if (n != 0) {
                s.next = p;
                break;
            } else {
                q.next = null;
                ListNode prev = null;
                ListNode curr = p;
                while (curr != null) {
                    ListNode nextTemp = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = nextTemp;
                }
                s.next = prev;
                while (s != null && s.next != null) { s = s.next; }
            }
        }
        return dummy.next;
    }
}