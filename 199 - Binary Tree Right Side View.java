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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) { return list; }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode t = q.poll();
                if (t.left != null) { q.offer(t.left); }
                if (t.right != null) { q.offer(t.right); }
                size -= 1;
                if (size == 0) { list.add(t.val); }
            }
        }
        return list;
    }
}