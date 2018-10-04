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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) { return new TreeNode(val); }
        TreeNode p = null;
        TreeNode r = root;
        while (r != null) {
            p = r;
            if (r.val > val) { 
                r = r.left; 
            } else if (r.val < val) { 
                r = r.right; 
            }
        }
        TreeNode n = new TreeNode(val);
        if (p.val > val) { p.left = n; }
        if (p.val < val) { p.right = n; }
        return root;
    }
}