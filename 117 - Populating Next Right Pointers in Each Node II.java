/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode p = root;
        TreeLinkNode head = null;
        TreeLinkNode q = null;

        while (p != null) {
            while (p != null) {
                if (p.left != null) {
                    if (head == null) {
                        head = p.left;
                        q = head;
                    } else {
                        q.next = p.left;
                        q = q.next;
                    }
                }
                if (p.right != null) {
                    if (head == null) {
                        head = p.right;
                        q = head;
                    } else {
                        q.next = p.right;
                        q = q.next;
                    }
                }
                p = p.next;
            }
            
            p = head;
            q = null;
            head = null;
        }
    }
}