class Solution {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) { return; }
        k = k % nums.length;
        swap(nums, 0, nums.length - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length - 1);
    }
    
    private void swap(int[] nums, int lo, int hi) {
        for (int i = 0; i < (hi - lo + 1) / 2; i++) {
            int temp = nums[lo + i];
            nums[lo + i] = nums[hi - i];
            nums[hi - i] = temp;
        }
    }
}