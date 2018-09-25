/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    private int maxDepth(Node root, int depth) {
        if (root == null) { return depth - 1; }
        int max = depth;
        for (Node n: root.children) {
            max = Math.max(max, maxDepth(n, depth + 1));
        }
        return max;
    }
    public int maxDepth(Node root) {
        return maxDepth(root, 1);
    }
}