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
    int count;
    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        if (root == null) { return count; }
        traverse(root);
        return count;
    }
    
    private boolean traverse(TreeNode root) {
        if (root == null) { return true; }
        if (root.left == null && root.right == null) {
            count += 1;
            return true;
        }
        boolean left = traverse(root.left);
        boolean right = traverse(root.right);
        if (root.left == null) {
            if (root.val == root.right.val && right) {
                count += 1;
                return true;
            } else {
                return false;
            }
        } else if (root.right == null) {
            if (root.val == root.left.val && left) {
                count += 1;
                return true;
            } else {
                return false;
            }
        } else {
            if (root.val == root.left.val && left &&
                root.val == root.right.val && right) {
                count += 1;
                return true;
            } else {
                return false;
            }
        }
    }
}