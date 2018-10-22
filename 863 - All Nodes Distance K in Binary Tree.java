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
    Map<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parents = new HashMap<>();
        dfs(root, null);
        
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(target);
        
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        List<Integer> ans = new ArrayList<>();
        
        int dis = 0;
        while (!q.isEmpty()) {
            if (dis == K) {
                for (TreeNode n: q) {
                    ans.add(n.val);
                }
                break;
            }
            int size = q.size();
            while (size > 0) {
                TreeNode n = q.poll();
                if (n.left != null && !visited.contains(n.left)) {
                    q.offer(n.left);
                    visited.add(n.left);
                }
                if (n.right != null && !visited.contains(n.right)) {
                    q.offer(n.right);
                    visited.add(n.right);
                }
                TreeNode p = parents.get(n);
                if (p != null && !visited.contains(p)) {
                    q.offer(p);
                    visited.add(p);
                }
                size -= 1;
            }
            dis += 1;
        }
        return ans;
    }
    
    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            parents.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}