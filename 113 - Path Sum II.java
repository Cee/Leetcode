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
    List<List<Integer>> ans;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        ans = new ArrayList<>();
        if (root == null) { return ans; }
        List<Integer> l = new ArrayList<>();
        l.add(root.val);
        traverse(root, sum, 0 + root.val, l);
        return ans;
    }
    
    private void traverse(TreeNode node, int sum, int cur, List<Integer> l) {
        if (node.left == null && node.right == null) {
            if (sum == cur) {
                ans.add(new ArrayList<>(l));
            }
        } else {
            if (node.left != null) {
                l.add(node.left.val);
                traverse(node.left, sum, cur + node.left.val, l);
                l.remove(l.size() - 1);
            }
            if (node.right != null) {
                l.add(node.right.val);
                traverse(node.right, sum, cur + node.right.val, l);
                l.remove(l.size() - 1);
            }
        }
    }
}