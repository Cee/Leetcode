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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) { return null; }
        TreeNode head;
        if (t1 != null && t2 == null) {
            head = t1;
        } else if (t1 == null && t2 != null) {
            head = t2;
        } else {
            head = t1;
            head.val += t2.val;
            head.left = mergeTrees(t1.left, t2.left);
            head.right = mergeTrees(t1.right, t2.right);
        }
        return head;
    }
}