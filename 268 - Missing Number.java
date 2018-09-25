class Solution {
    public int missingNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i] - i;
        }
        ans = nums.length - ans;
        return ans;
    }
}