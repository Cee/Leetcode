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
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }
    
    private boolean inorder(TreeNode root) {
        if (root == null) { return true; }
        boolean left = inorder(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        boolean right = inorder(root.right);
        return left && right;
    }
}