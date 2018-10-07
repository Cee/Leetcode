class RLEIterator {

    int[] counts;
    int[] nums;
    int idx;
    int count;
    int len;
    public RLEIterator(int[] A) {
        len = A.length / 2;
        counts = new int[len];
        nums = new int[len];
        for (int i = 0; i < len; i++) {
            counts[i] = A[2 * i];
            nums[i] = A[2 * i + 1];
        }
        idx = -1;
        count = 0;
    }
    
    public int next(int n) {
        count -= n;
        while (count < 0) {
            idx += 1;
            if (idx >= len) { return -1; }
            count += counts[idx];
        }
        return nums[idx];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */