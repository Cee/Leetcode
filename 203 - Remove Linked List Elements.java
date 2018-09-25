/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode t = head;
        while (t != null) {
            if (t.val == val) {
                pre.next = t.next;
            } else {
                pre = pre.next;
            }
            t = t.next;
        }
        return dummy.next;
    }
}