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
    // if root.val <= V, all nodes under root.left(including root) will
    // be in the smaller/eq tree, we then split the root.right subtree 
    // into (smaller/eq, larger), the root only need to concat the 
    // smaller/eq one from the subproblem result (recursion).
    public TreeNode[] splitBST(TreeNode root, int V) {
        TreeNode[] nodes = new TreeNode[]{null, null};
        if (root == null) { return nodes; }
        
        if (root.val <= V) {
            nodes = splitBST(root.right, V);
            root.right = nodes[0];
            nodes[0] = root;
        } else {
            nodes = splitBST(root.left, V);
            root.left = nodes[1];
            nodes[1] = root;
        }
        return nodes;
    }
    
   
}