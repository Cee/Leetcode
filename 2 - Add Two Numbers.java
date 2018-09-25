/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bit = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            int ans = l1.val + l2.val + bit;
            bit = ans / 10;
            ans = ans % 10;
            head.next = new ListNode(ans);
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int ans = l1.val + bit;
            bit = ans / 10;
            ans = ans % 10;
            head.next = new ListNode(ans);
            head = head.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int ans = l2.val + bit;
            bit = ans / 10;
            ans = ans % 10;
            head.next = new ListNode(ans);
            head = head.next;
            l2 = l2.next;
        }
        if (bit != 0) {
            head.next = new ListNode(bit);
        }
        return dummy.next;
    }
}