/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     Map<Integer, Integer> map;
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
//         if (preorder == null) { return null; }
//         map = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             map.put(inorder[i], i);
//         }
//         return build(preorder, inorder, 0, preorder.length - 1, 0);
//     }
    
//     private TreeNode build(int[] preorder, int[] inorder, int left, int right, int idx) {
//         if (left > right) { return null; }
//         TreeNode root = new TreeNode(preorder[idx]);
//         if (left == right) { return root; }
//         int i = map.get(root.val);
//         root.left = build(preorder, inorder, left, i - 1, idx + 1);
//         root.right = build(preorder, inorder, i + 1, right, i + 1);
//         return root;
//     }
// }
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // deal with edge case(s)
        if (preorder.length == 0) {
            return null;
        }
        
        // build a map of the indices of the values as they appear in the inorder array
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        // initialize the stack of tree nodes
        Stack<TreeNode> stack = new Stack<>();
        int value = preorder[0];
        TreeNode root = new TreeNode(value);
        stack.push(root);
        
        // for all remaining values...
        for (int i = 1; i < preorder.length; i ++) {
            // create a node
            value = preorder[i];
            TreeNode node = new TreeNode(value);
            
            if (map.get(value) < map.get(stack.peek().val)) {
                // the new node is on the left of the last node,
                // so it must be its left child (that's the way preorder works)
                stack.peek().left = node;
            } else {
                // the new node is on the right of the last node,
                // so it must be the right child of either the last node
                // or one of the last node's ancestors.
                // pop the stack until we either run out of ancestors
                // or the node at the top of the stack is to the right of the new node
                TreeNode parent = null;
                while(!stack.isEmpty() && map.get(value) > map.get(stack.peek().val)) {
                    parent = stack.pop();
                }
                parent.right = node;
            }
            stack.push(node);
        }
        
        return root;
    }
}