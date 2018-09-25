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
    public int longestConsecutive(TreeNode root) {
        max = 0;
        helper(root);
        return max;
    }
    
    public int[] helper(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) { return ans; }
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        if (root.left != null) {
            if (root.val != root.left.val - 1) { left[0] = 0; }
            if (root.val != root.left.val + 1) { left[1] = 0; }
        }
        if (root.right != null) {
            if (root.val != root.right.val - 1) { right[0] = 0; }
            if (root.val != root.right.val + 1) { right[1] = 0; }
        }
        ans[0] = Math.max(left[0], right[0]) + 1;
        ans[1] = Math.max(left[1], right[1]) + 1;
        
        max = Math.max(max, ans[0] + ans[1] - 1);
        return ans;
    } 
}