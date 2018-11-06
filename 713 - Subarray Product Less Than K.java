class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // less than k
        if (k <= 1) { return 0; }
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod = prod / nums[left];
                left += 1;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}