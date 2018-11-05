/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) { return null; }
        Node dummy = new Node();
        dummy.next = head;
        Node p = dummy;
        while (p != null) {
            if (p.child == null) { p = p.next; continue; }
            Node next = p.next;
            Node child = p.child;
            p.child = null;
            Node flat = flatten(child);
            flat.prev = p;
            p.next = flat;
            while (p.next != null) { p = p.next; }
            if (next != null) {
                p.next = next;
                next.prev = p;
            }
            p = p.next;
        }
        return dummy.next;
    }
}