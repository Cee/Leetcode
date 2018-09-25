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
    public TreeNode pruneTree(TreeNode root) {
        contains(root);
        return root;
    }
    
    private boolean contains(TreeNode t) {
        if (t == null) { return false; }
        boolean left = contains(t.left);
        boolean right = contains(t.right);
        if (t.left != null && !left) {
            t.left = null;
        }
        if (t.right != null && !right) {
            t.right = null;
        }
        return left || right || t.val == 1;
    }
}