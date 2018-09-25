class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return 0; }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) { return mi; }
            if (nums[mi] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return lo;
    }
}