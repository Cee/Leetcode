class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int n = nums.length;
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i + 1] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i + 1] = Math.max(dp[i + 1], dp[j + 1] + 1);
                }
            }
            max = Math.max(max, dp[i + 1]);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}