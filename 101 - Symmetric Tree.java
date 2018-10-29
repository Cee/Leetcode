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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    private boolean isMirror(TreeNode l, TreeNode r) {
        if (l == null && r == null) { return true; }
        if (l != null && r == null) { return false; }
        if (l == null && r != null) { return false; }
        return (l.val == r.val) && isMirror(l.right, r.left) && isMirror(l.left, r.right);
    }
}