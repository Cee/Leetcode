class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            max = Math.max(max, sum);
        }
        return max;
    }
}