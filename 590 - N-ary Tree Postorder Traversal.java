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
    List<Integer> list;
    public List<Integer> postorder(Node root) {
        list = new ArrayList<>();
        traverse(root);
        return list;
    }
    
    private void traverse(Node n) {
        if (n == null) { return; }
        for (Node c: n.children) {
            traverse(c);
        }
        list.add(n.val);
    }
}