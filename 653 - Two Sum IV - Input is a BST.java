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
    
    Set<Integer> set;
    
    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return helper(root, k);
    }
    
    public boolean helper(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (set.contains(root.val)) {
            return true;
        } else {
            set.add(target - root.val);
            return helper(root.left, target) || helper(root.right, target);
        }
    }
}