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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        if (root == null) { return sum; }
        traverse(root, 0);
        return sum;
    }
    
    private void traverse(TreeNode node, int curr) {
        if (node.left == null && node.right == null) {
            sum += (curr * 10 + node.val);
            return;
        }
        if (node.left != null) { traverse(node.left, curr * 10 + node.val); }
        if (node.right != null) { traverse(node.right, curr * 10 + node.val); }
    }
}