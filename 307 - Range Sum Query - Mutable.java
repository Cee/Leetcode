class NumArray {

    int[] nums;
    int[] sum;
    
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        int delta = val - nums[i];
        for (int j = i; j < nums.length; j++) {
            sum[j + 1] += delta;
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */