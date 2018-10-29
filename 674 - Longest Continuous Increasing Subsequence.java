class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        int count = 0;
        Integer prev = null;
        for (int num: nums) {
            if (prev == null || num > prev) {
                count += 1;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
            prev = num;
        }
        return max;
    }
}