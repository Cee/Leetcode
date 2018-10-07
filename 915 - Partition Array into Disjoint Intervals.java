class Solution {
    class SegmentTree {
        int min;
        int max;
        int start;
        int end;
        SegmentTree left;
        SegmentTree right;
        SegmentTree(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.min = Integer.MAX_VALUE;
            this.max = Integer.MIN_VALUE;
        }
    }
    
    public SegmentTree build(int[] nums, int start, int end) {
        if (start > end) { return null; }
        SegmentTree head = new SegmentTree(start, end);
        if (start == end) {
            head.min = nums[start];
            head.max = nums[start];
        } else {
            int mi = start + (end - start) / 2;
            head.left = build(nums, start, mi);
            head.right = build(nums, mi + 1, end);
            head.min = Math.min(head.left == null ? Integer.MAX_VALUE : head.left.min,
                                head.right == null ? Integer.MAX_VALUE : head.right.min);
            head.max = Math.max(head.left == null ? Integer.MIN_VALUE : head.left.max,
                                head.right == null ? Integer.MIN_VALUE : head.right.max);
        }
        return head;
    }
    
    public int queryMin(int[] nums, SegmentTree root, int start, int end) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        if (root.start == start && root.end == end) {
            return root.min;
        }
        int mi = root.start + (root.end - root.start) / 2;
        if (mi < start) {
            return queryMin(nums, root.right, start, end);
        } else if (mi > end) {
            return queryMin(nums, root.left, start, end);
        } else {
            return Math.min(queryMin(nums, root.left, start, mi), queryMin(nums, root.right, mi + 1, end));
        }
    }
    
    public int queryMax(int[] nums, SegmentTree root, int start, int end) {
        if (start > end) {
            return Integer.MIN_VALUE;
        }
        if (root.start == start && root.end == end) {
            return root.max;
        }
        int mi = root.start + (root.end - root.start) / 2;
        if (mi < start) {
            return queryMax(nums, root.right, start, end);
        } else if (mi > end) {
            return queryMax(nums, root.left, start, end);
        } else {
            return Math.max(queryMax(nums, root.left, start, mi), queryMax(nums, root.right, mi + 1, end));
        }
    }
    
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        SegmentTree st = build(A, 0, n - 1);
        for (int i = 0; i < n; i++) {
            int mi = i;
            int max = queryMax(A, st, 0, mi);
            int min = queryMin(A, st, mi + 1, n - 1);
            if (max <= min) {
                return i + 1;
            } 
        }
        return 0;
    }
}