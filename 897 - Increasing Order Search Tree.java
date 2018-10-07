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
    TreeNode head;
    TreeNode p;
    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        return head;
    }
    
    private void traverse(TreeNode node) {
        if (node == null) { return; }
        traverse(node.left);
        TreeNode n = new TreeNode(node.val);
        if (head == null) {
            head = n;
            p = n;
        } else {
            p.right = n;
            p = p.right;
        }
        traverse(node.right);
    }
}