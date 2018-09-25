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
    List<Double> ans;
    List<Integer> count;
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) { return null; }
        ans = new ArrayList<>();
        count = new ArrayList<>();
        traverse(root, 1);
        for (int i = 0; i < ans.size(); i++) {
            ans.set(i, ans.get(i) / count.get(i));
        }
        return ans;
    }
    
    private void traverse(TreeNode node, int level) {
        if (node == null) { return; }
        if (ans.size() < level) {
            ans.add((double)(node.val));
            count.add(1);
        } else {
            ans.set(level - 1, ans.get(level - 1) + node.val);
            count.set(level - 1, count.get(level - 1) + 1);
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}