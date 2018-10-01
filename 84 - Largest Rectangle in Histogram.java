// Stack
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxarea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 &&
                heights[stack.peek()] >= heights[i]) {
                int area = heights[stack.pop()] * (i - stack.peek() - 1);
                maxarea = Math.max(maxarea, area);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            maxarea = Math.max(maxarea, heights[stack.pop()] * (heights.length - stack.peek() -1));
        }
        return maxarea;
    }
}

// Divide and Conquer
class Solution {
    public int calculateArea(int[] heights, int start, int end) {
        if (start > end) {
            return 0;
        }
        int minIndex = start;
        for (int i = start; i <= end; i++) {
            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }
        return Math.max(heights[minIndex] * (end - start + 1), Math.max(calculateArea(heights, start, minIndex - 1), calculateArea(heights, minIndex + 1, end)));
    }
    public int largestRectangleArea(int[] heights) {
        return calculateArea(heights, 0, heights.length - 1);
    }
}


// Segment Tree
class Solution {
    class SegmentTree {
        int min; // place index instead of number
        int start;
        int end;
        SegmentTree left;
        SegmentTree right;
        SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.min = -1;
        }
    }
    
    SegmentTree build(int[] nums, int start, int end) {
        if (start > end) { return null; }
        SegmentTree head = new SegmentTree(start, end);
        if (start == end) {
            head.min = start;
        } else {
            int mi = start + (end - start) / 2;
            head.left = build(nums, start, mi);
            head.right = build(nums, mi + 1, end);
            if (head.left != null && head.right != null) {
                head.min = nums[head.left.min] < nums[head.right.min] ? head.left.min : head.right.min;
            } else if (head.left == null) {
                head.min = head.right.min;
            } else if (head.right == null) {
                head.min = head.left.min;
            }
        }
        return head;
    }
    
    int query(int[] nums, SegmentTree root, int start, int end) {
        if (root == null || start > end || end < root.start || start > root.end) {
            return -1;
        }
        if (root.start >= start && root.end <= end) {
            return root.min;
        }
        int leftMin = query(nums, root.left, start, end);
        int rightMin = query(nums, root.right, start, end);
        if (leftMin == -1) { return rightMin; }
        if (rightMin == -1) { return leftMin; }
        return nums[leftMin] < nums[rightMin] ? leftMin : rightMin;
    }
    
    int calculateMax(int[] heights, SegmentTree root, int start, int end) {
        if (start > end) { return -1; }
        if (start == end) { return heights[start]; }
        int minIndex = query(heights, root, start, end);
        int leftMax = calculateMax(heights, root, start, minIndex - 1);
        int rightMax = calculateMax(heights, root, minIndex + 1, end);
        int minMax = heights[minIndex] * (end - start + 1);
        return Math.max(Math.max(leftMax, rightMax), minMax);
    }
    
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) { return 0; }
        SegmentTree root = build(heights, 0, heights.length - 1);
        return calculateMax(heights, root, 0, heights.length - 1);
    }
}