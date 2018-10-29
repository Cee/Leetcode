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
    int min;
    public int minDepth(TreeNode root) {
        if (root == null) { return 0; }
        min = Integer.MAX_VALUE;
        backtrack(root, 1);
        return min;
    }
    
    private void backtrack(TreeNode node, int depth) {
        if (node.left == null && node.right == null) {
            min = Math.min(min, depth);
            return;
        }
        if (node.left != null) { backtrack(node.left, depth + 1); }
        if (node.right != null) { backtrack(node.right, depth + 1); }
    }
}