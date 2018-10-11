/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        return insert(null, head);
    }
    
    private ListNode insert(ListNode sorted, ListNode head) {
        if (head == null) { return sorted; }
        ListNode next = head.next;
        if (sorted == null) {
            sorted = head;
            head.next = null;
            return insert(sorted, next);
        }
        if (sorted.val > head.val) {
            head.next = sorted;
            sorted = head;
            return insert(sorted, next);
        }
        ListNode prev = null;
        ListNode curr = sorted;
        while (curr != null) {
            if (curr.val <= head.val) {
                prev = curr;
                curr = curr.next;
            } else {
                break;
            }
        }
        prev.next = head;
        head.next = curr;
        return insert(sorted, next);
    }
}