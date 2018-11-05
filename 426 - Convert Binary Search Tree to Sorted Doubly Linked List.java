/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Stack<Node> stack;
    public Node treeToDoublyList(Node root) {
        stack = new Stack<>();
        inorder(root);
        if (stack.isEmpty()) { return root; }
        List<Node> l = new ArrayList<>(stack);
        for (int i = 0; i < l.size(); i++) {
            l.get(i).right = l.get((i + 1) % l.size());
            l.get(i).left = l.get((i - 1 + l.size()) % l.size());
        }
        return l.get(0);
    }
    
    private void inorder(Node root) {
        if (root == null) { return; }
        inorder(root.left);
        stack.push(root);
        inorder(root.right);
    }
}