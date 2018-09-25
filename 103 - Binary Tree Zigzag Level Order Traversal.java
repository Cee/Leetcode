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
    List<List<Integer>> list;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        list = new ArrayList<>();
        if (root == null) { return list; }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reverse = false;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = q.poll();
                if (n.left != null) { q.offer(n.left); }
                if (n.right != null) { q.offer(n.right); }
                temp.add(n.val);
            }
            if (reverse) {
                Collections.reverse(temp);
            }
            list.add(temp);
            reverse = !reverse;
        }
        return list;
    }
}