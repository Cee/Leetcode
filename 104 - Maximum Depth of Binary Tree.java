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
//     int max;
//     public int maxDepth(TreeNode root) {
//         if (root == null) { return 0; }
//         max = 0;
//         traverse(root, 1);
//         return max;
//     }
    
//     private void traverse(TreeNode root, int depth) {
//         if (root == null) { return; }
//         traverse(root.left, depth + 1);
//         traverse(root.right, depth + 1);
//         max = Math.max(depth, max);
//     }
    public int maxDepth(TreeNode root) {
        if (root == null) { return 0; }
        int depth = 0;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.offer(root);
        while (!list.isEmpty()) {
            depth += 1;
            int size = list.size();
            while (size > 0) {
                TreeNode n = list.poll();
                if (n.left != null) { list.offer(n.left); }
                if (n.right != null) { list.offer(n.right); }
                size -= 1;
            }
        }
        return depth;
    }

// public int maxDepth(TreeNode root) {
    // if (root == null) { return 0; }
    // return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
// }
}