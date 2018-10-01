/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) { return null; }
        if (lists.length == 1) { return lists[0]; }
        ListNode h = lists[0];
        for (int i = 1; i < lists.length; i++) {
            h = merge(h, lists[i]);
        }
        return h;
    }
    
    private ListNode merge(ListNode l, ListNode r) {
        ListNode dummy = new ListNode(0);
        ListNode h = dummy;
        while (l != null && r != null) {
            if (l.val < r.val) {
                h.next = l;
                l = l.next;
            } else {
                h.next = r;
                r = r.next;
            }
            h = h.next;
        }
        if (l != null) {
            h.next = l;
        }
        if (r != null) {
            h.next = r;
        }
        return dummy.next;
    }
}