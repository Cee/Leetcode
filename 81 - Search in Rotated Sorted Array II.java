class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) { return false; }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] == target) { return true; }
            if (nums[mi] == nums[hi]) { 
                hi -= 1; 
            } else if (nums[mi] > nums[hi]) {
                if (target >= nums[lo] && target < nums[mi]) {
                    hi = mi - 1;
                } else {
                    lo = mi + 1;
                }
            } else {
                if (target > nums[mi] && target <= nums[hi]) {
                    lo = mi + 1;
                } else {
                    hi = mi - 1;
                }
            }
        }
        return false;
    }
}