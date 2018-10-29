/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        Node n = new Node();
        n.val = insertVal;
        if (head == null) {
            n.next = n;
            return n;
        }
        Node p = head;
        while (true) {
            if (p.val < p.next.val && p.val <= insertVal && insertVal <= p.next.val) { break; }
            if (p.val > p.next.val && (insertVal >= p.val || insertVal <= p.next.val)) { break; }
            if (p.val == p.next.val && (p.next == head || p.val == insertVal)) { break; }
            p = p.next;
        }
        n.next = p.next;
        p.next = n;
        return head;
    }
}