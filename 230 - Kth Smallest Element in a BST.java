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
    Integer ans;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        ans = null;
        this.k = k;
        inorder(root);
        return ans;
    }
    
    private void inorder(TreeNode root) {
        if (root == null) { return; }
        inorder(root.left);
        if (k == 1 && ans == null) { ans = root.val; return; }
        k -= 1;
        inorder(root.right);
    }
}