class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int prev = 0;
        int max = 0;
        for (int x: nums) {
            int temp = max;
            max = Math.max(prev + x, max);
            prev = temp;
        }
        return max;
    }
}