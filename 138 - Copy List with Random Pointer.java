/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
// Recursive
public class Solution {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<RandomListNode, RandomListNode> visitedHash = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) { return null; }
        if (visitedHash.containsKey(head)) {
             return visitedHash.get(head);
        }
        
        RandomListNode node = new RandomListNode(head.label);
        visitedHash.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);
        
        return node;
    }
}

// Iterative
public class Solution {
    // HashMap which holds old nodes as keys and new nodes as its values.
    HashMap<RandomListNode, RandomListNode> visitedHash = new HashMap<>();

    public RandomListNode getClonedNode(RandomListNode head) {
        if (head == null) { return null; }
        return visitedHash.getOrDefault(head, new RandomListNode(head.label));
    }
    
    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) { return null; }
        RandomListNode h = head;
        RandomListNode p = new RandomListNode(head.label);
        visitedHash.put(head, p);
        
        while (p != null) {
            p.random = getClonedNode(head.random);
            p.next = getClonedNode(head.next);
            p = p.next;
            head = head.next;
        }
        
        return getClonedNode(h);
    }
}

// O(1)
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = p.next.next;
        }
        
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode q = dummy;
        p = head;
        while (p != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        
        return dummy.next;
    }
}