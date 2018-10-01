/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return helper(root, "");
    }
    
    private String helper(TreeNode root, String s) {
        if (root == null) {
            s += "#,";
        } else {
            s += String.valueOf(root.val) + ",";
            s = helper(root.left, s);
            s = helper(root.right, s);
        }
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        LinkedList<String> l = new LinkedList<>(Arrays.asList(arr));
        return h(l);
    }
    
    private TreeNode h(LinkedList<String> l) {
        String s = l.poll();
        if (s.equals("#")) { return null; }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = h(l);
        root.right = h(l);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));