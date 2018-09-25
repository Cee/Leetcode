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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int i, int j) {
        if (i > j) { return null; }
        if (i == j) {
            TreeNode t = new TreeNode(nums[i]);
            return t;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int k = i; k <= j; k++) {
            if (nums[k] > max) {
                max = nums[k];
                index = k;
            }
        }
        TreeNode t = new TreeNode(max);
        t.left = helper(nums, i, index - 1);
        t.right = helper(nums, index + 1, j);
        return t;
    }
}