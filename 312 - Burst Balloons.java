class Solution {
    public int maxCoins(int[] nums) {
        int[] a = new int[nums.length + 2];
        a[0] = 1;
        a[nums.length + 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            a[i + 1] = nums[i];
        }
        
        int n = nums.length + 2;
        int[][] memo = new int[n][n];
        return helper(memo, a, 0, n - 1);
    }
    
    private int helper(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) { return 0; }
        if (memo[left][right] > 0) { return memo[left][right]; }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                              + helper(memo, nums, left, i)
                              + helper(memo, nums, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}