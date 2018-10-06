class NumArray {
    
    class SegementTree {
        int sum;
        int start;
        int end;
        SegementTree left;
        SegementTree right;
        
        public SegementTree(int sum, int start, int end) {
            this.sum = sum;
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
        }
    }
    
    public SegementTree buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new SegementTree(nums[start], start, end);
        }
        SegementTree node = new SegementTree(0, start, end);
        int mid = start + (end - start) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);
        node.sum = (node.left == null ? 0 : node.left.sum) + (node.right == null ? 0 : node.right.sum);
        return node;
    }
    
    SegementTree root;
    public NumArray(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }
    
    public void update(int i, int val) {
        SegementTree cur = root;
        update(cur, i, val);
    }
    
    public void update(SegementTree root, int pos, int val) {
        if (root == null) {
            return;
        }
        if (root.start == pos && root.end == pos) {
            root.sum = val;
            return;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (pos <= mid) {
            update(root.left, pos, val);
        }
        else {
            update(root.right, pos, val);
        }
        root.sum = (root.left == null ? 0 : root.left.sum) + (root.right == null ? 0 : root.right.sum);
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    public int sumRange(SegementTree root, int start, int end) {
        if (start > end) {
            return 0;
        }
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (mid < start) {
            return sumRange(root.right, start, end);
        }
        else if (mid > end){
            return sumRange(root.left, start, end);
        }
        else {
            return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
        }
        
    }
}
