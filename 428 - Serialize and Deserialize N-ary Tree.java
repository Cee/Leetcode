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
class Codec {

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        if (root == null) { return ""; }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(root.children.size());
        sb.append("#");
        for (Node c: root.children) {
            sb.append(serialize(c));
        }
        return sb.toString();
    }

    class Rep {
        Node n;
        int end;
    }
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.length() == 0) { return null; }
        return parse(data, 0, data.length() - 1).n;
    }
    
    private Rep parse(String data, int start, int end) {
        if (start >= end) { return null; }
        int comma = data.indexOf(",", start);
        int split = data.indexOf("#", start);
        int val = Integer.valueOf(data.substring(start, comma));
        int childNum = Integer.valueOf(data.substring(comma + 1, split));
        Node n = new Node();
        n.val = val;
        List<Node> children = new ArrayList<>();
        int last = split;
        for (int i = 0; i < childNum; i++) {
            Rep rep = parse(data, last + 1, end);
            last = rep.end;
            children.add(rep.n);
        }
        n.children = children;
        Rep r = new Rep();
        r.n = n;
        r.end = last;
        return r;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));