/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int num: G) {
            set.add(num);
        }
        
        boolean flag = false;
        while (!set.isEmpty()) {
            if (head == null) { break; }
            int val = head.val;
            if (set.contains(val)) {
                flag = true;
                set.remove(val);
            } else if (flag) {
                count += 1;
                flag = false;
            }
            head = head.next;
        }
        return flag ? count + 1 : count;
    }
}