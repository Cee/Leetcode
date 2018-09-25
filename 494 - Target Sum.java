class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        return sum < s || (s + sum) % 2 == 1 ? 0 : subsetSum(nums, (s + sum) >>> 1); 
    }   

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = s; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[s];
    }
}


class Solution {
    int count;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) { return 0; }
        count = 0;
        dfs(nums, 0, 0, nums.length, S);
        return count;
    }
    
    private void dfs(int[] nums, int i, int sum, int n, int target) {
        if (i == n) {
            if (sum == target) {
                count += 1;
            }
            return;
        }
        int s;
        s = sum + nums[i];
        dfs(nums, i + 1, s, n, target);
        s = sum - nums[i];
        dfs(nums, i + 1, s, n, target);
    }
}