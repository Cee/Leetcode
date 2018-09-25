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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        list = new ArrayList<>();
        dfs(root, "");
        return list;
    }
    
    private void dfs(TreeNode node, String s) {
        if (node == null) { return; }
        s += String.valueOf(node.val);
        if (node.left == null && node.right == null) {
            list.add(s);
            return;
        }
        dfs(node.left, s + "->");
        dfs(node.right, s + "->");
    }
}