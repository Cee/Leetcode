/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Pair {
    TreeNode node;
    int col;
    Pair(TreeNode n, int c) { node = n; col = c; }
}
class Solution {
    Map<Integer, List<Integer>> map;
    int min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        map = new HashMap<>();
        List<List<Integer>> l = new ArrayList<>();
        if (root == null) { return l; }
        LinkedList<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            if (!map.containsKey(p.col)) {
                map.put(p.col, new ArrayList<>());
            }
            min = Math.min(min, p.col);
            map.get(p.col).add(p.node.val);
            if (p.node.left != null) { q.offer(new Pair(p.node.left, p.col - 1)); }
            if (p.node.right != null) { q.offer(new Pair(p.node.right, p.col + 1)); }
        }
        while (map.containsKey(min)) {
            l.add(map.get(min));
            min += 1;
        }
        return l;
    }
}