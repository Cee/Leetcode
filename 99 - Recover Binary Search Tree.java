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
    TreeNode first;
    TreeNode second;
    TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        traverse(root);
        
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) { return; }
        traverse(node.left);
        if (first == null && prev.val >= node.val) { first = prev; }
        if (first != null && prev.val >= node.val) { second = node; }
        prev = node;
        traverse(node.right);
    }
}