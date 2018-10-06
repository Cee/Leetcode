class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) { return true; }
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 0; i < n - 1; i++) {
            if (!dp[i]) { continue; }
            if (i + nums[i] >= n - 1) { return true; }
            for (int j = 1; j <= nums[i] && i + j < n; j++) {
                dp[i + j] = true;
            }
        }
        return false;
    }
    
    public boolean canJump(int[] nums) {
        int reachable = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) { return false; }
            reachable = Math.max(reachable, i + nums[i]);
            if (reachable > nums.length - 1) { return true; }
        }
        return true;
    }
    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int last = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= last) {
                last = i;
            }
        }
        return last == 0;
    }
}