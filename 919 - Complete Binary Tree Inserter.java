/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class CBTInserter {

    TreeNode[] arr;
    int size;
    public CBTInserter(TreeNode root) {
        arr = new TreeNode[10000];
        size = 0;
        if (root == null) { return; }
        LinkedList<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            arr[size + 1] = t;
            size++;
            if (t.left != null) { q.offer(t.left); }
            if (t.right != null) { q.offer(t.right); }
        }
    }
    
    public int insert(int v) {
        if (size == 0) {
            arr[1] = new TreeNode(v);
            size = 1;
            return v;
        }
        arr[size + 1] = new TreeNode(v);
        int parent = (size + 1) / 2;
        if ((size + 1) % 2 == 0) {
            arr[parent].left = arr[size + 1];
        } else {
            arr[parent].right = arr[size + 1];
        }
        size++;
        return arr[parent].val;
    }
    
    public TreeNode get_root() {
        return arr[1];
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(v);
 * TreeNode param_2 = obj.get_root();
 */