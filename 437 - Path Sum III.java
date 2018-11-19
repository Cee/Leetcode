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
    HashMap<Integer, Integer> preSum;
    public int pathSum(TreeNode root, int sum) {
        preSum = new HashMap<>();
        preSum.put(0, 1);
        return helper(root, 0, sum);
    }
    
    public int helper(TreeNode root, int currSum, int target) {
        if (root == null) { return 0; }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        res += helper(root.left, currSum, target) + helper(root.right, currSum, target);
        preSum.put(currSum, preSum.get(currSum) - 1);
        
        return res;
    }
}