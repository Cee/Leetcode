/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode i = dummy;
        ListNode j = dummy;

        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        // i = index of last non-9 digit
    
        i.val++;
        i = i.next;
        while (i != null) {
            i.val = 0;
            i = i.next;
        }
        
        if (dummy.val == 0) return dummy.next;
        return dummy;
    }
}