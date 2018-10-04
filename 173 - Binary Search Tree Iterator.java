/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {

    Stack<TreeNode> stack;
    TreeNode p;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        p = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (p == null && stack.isEmpty()) { return false; }
        while (p != null) {
            stack.push(p);
            p = p.left;
        }
        p = stack.pop();
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        int val = p.val;
        if (p.right != null) { 
            p = p.right;
        } else {
            p = null;
        }
        return val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */