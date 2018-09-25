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
    public int widthOfBinaryTree(TreeNode root) {
        int max = 0;
        if (root == null) { return max; }
        LinkedList<Long> l = new LinkedList<>();
        LinkedList<TreeNode> t = new LinkedList<>();
        l.offer((long)1);
        t.offer(root);
        while (!l.isEmpty()) {
            int n = l.size();
            long lo = 0;
            long hi = 0;
            for (int i = 0; i < n; i++) {
                long j = l.poll();
                TreeNode node = t.poll();
                if (lo == 0) { lo = j; }
                hi = j;
                if (node.left != null) {
                    l.offer((long)(j * 2));
                    t.offer(node.left);
                }
                if (node.right != null) {
                    l.offer((long)(j * 2 + 1));
                    t.offer(node.right);
                }
            }
            System.out.println(hi - lo + 1);
            max = Math.max(max, (int)(hi - lo + 1));
        }
        return max;
    }
}

class Solution {
    int ans;
    Map<Integer, Integer> left;
    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap();
        dfs(root, 0, 0);
        return ans;
    }
    public void dfs(TreeNode root, int depth, int pos) {
        if (root == null) return;
        left.computeIfAbsent(depth, x-> pos);
        ans = Math.max(ans, pos - left.get(depth) + 1);
        dfs(root.left, depth + 1, 2 * pos);
        dfs(root.right, depth + 1, 2 * pos + 1);
    }
}