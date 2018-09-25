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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) { return root; }
        TreeNode t = root.right;
        root.right = root.left;
        root.left = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}