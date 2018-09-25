class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int ans = 0;
        for (int num: nums) {
            ans ^= num;
        }
        return ans;
    }
}


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (mi % 2 == 1) mi--;
            
            if (nums[mi] != nums[mi + 1]) {
                // We didn't find a pair. The single element must be on the left.
                // (pipes mean start & end)
                // Example: |0 1 1 3 3 6 6|
                //               ^ ^
                // Next:    |0 1 1|3 3 6 6
                hi = mi;
            } else {
                // We found a pair. The single element must be on the right.
                // Example: |1 1 3 3 5 6 6|
                //               ^ ^
                // Next:     1 1 3 3|5 6 6|
                lo = mi + 2;
            }
        }
        return nums[lo];
    }
}