class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int n = nums.length;
        int ans = n;
        int lo = 0;
        int hi = 0;
        int count = 0;
        int sum = 0;
        while (hi < n) {
            while (hi < n && sum < s) {
                sum += nums[hi];
                hi += 1;
                count += 1;
            }
            if (sum < s && hi == n && count == n) { return 0; }
            while (lo <= hi && sum >= s) {
                ans = Math.min(ans, count);
                sum -= nums[lo];
                lo += 1;
                count -= 1;
            }
        }
        return ans;
    }
}