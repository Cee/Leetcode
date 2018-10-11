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
    Map<TreeNode, List<TreeNode>> graph;
    Map<Integer, TreeNode> idx;
    public int findClosestLeaf(TreeNode root, int k) {
        graph = new HashMap<>();
        idx = new HashMap<>();
        dfs(root, null);
        
        Set<Integer> visited = new HashSet<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        visited.add(k);
        q.offer(idx.get(k));
        
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                TreeNode n = q.poll();
                if (n.left == null && n.right == null) { return n.val; }
                for (TreeNode next: graph.get(n)) {
                    if (next != null && !visited.contains(next.val)) {
                        visited.add(next.val);
                        q.offer(next);
                    }
                }
                size -= 1;
            }
        }
        return 0;
    }
    
    private void dfs(TreeNode node, TreeNode parent) {
        if (node == null) { return; }
        if (!graph.containsKey(parent)) { graph.put(parent, new ArrayList<>()); }
        if (!graph.containsKey(node)) { graph.put(node, new ArrayList<>()); }
        graph.get(parent).add(node);
        graph.get(node).add(parent);
        idx.put(node.val, node);
        dfs(node.left, node);
        dfs(node.right, node);
    }
}