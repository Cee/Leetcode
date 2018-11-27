/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) { return null; }
        node = head;
        int n = 0;
        while (head != null) {
            n += 1;
            head = head.next;
        }
        return balanced(0, n - 1);
    }
    
    private TreeNode balanced(int lo, int hi) {
        if (lo > hi) { return null; }
        int mi = lo + (hi - lo) / 2;
        TreeNode left = balanced(lo, mi - 1);
        TreeNode t = new TreeNode(node.val);
        node = node.next;
        TreeNode right = balanced(mi + 1, hi);
        
        t.left = left;
        t.right = right;
        return t;
    }
}