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
    int max;
    public int longestUnivaluePath(TreeNode root) {
        max = 0;
        search(root);
        return max;
    }
    
    private int search(TreeNode root) {
        if (root == null) { return 0; }
        int left = search(root.left);
        int right = search(root.right);
        int arrowLeft = 0;
        int arrowRight = 0;
        if (root.left != null && root.val == root.left.val) {
            arrowLeft = left + 1;
        }
        if (root.right != null && root.val == root.right.val) {
            arrowRight = right + 1;
        }
        max = Math.max(max, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}