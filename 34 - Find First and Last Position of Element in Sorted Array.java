class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{ -1, -1 };
        if (nums == null || nums.length == 0) { return ans; }
        int lo = 0;
        int hi = nums.length - 1;
        
        // If A[mid] < target, then the range must begins on the right of mid (hence i = mid+1 for the next iteration)
        // If A[mid] > target, it means the range must begins on the left of mid (j = mid-1)
        // If A[mid] = target, then the range must begins on the left of or at mid (j= mid)
        
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < target) {
                lo = mi + 1;
            } else if (nums[mi] > target) {
                hi = mi - 1;
            } else {
                hi = mi;
            }
        }
        
        if (nums[lo] != target) { return ans; }
        ans[0] = lo;
        
        hi = nums.length - 1;
        
        while (lo < hi) {
            // Why does this trick work? When we use mid = (i+j)/2, 
            // the mid is rounded to the lowest integer. In other words, 
            // mid is always biased towards the left. This means we could 
            // have i == mid when j - i == mid, but we NEVER have j == mid. 
            // So in order to keep the search range moving, you must make sure
            // the new i is set to something different than mid, otherwise we 
            // are at the risk that i gets stuck. But for the new j, it is okay
            // if we set it to mid, since it was not equal to mid anyways. 
            // Our two rules in search of the left boundary happen to satisfy 
            // these requirements, so it works perfectly in that situation. 
            // Similarly, when we search for the right boundary, we must make 
            // sure i won't get stuck when we set the new i to i = mid. The easiest 
            // way to achieve this is by making mid biased to the right, i.e. 
            // mid = (i+j)/2+1.
            int mi = lo + (hi - lo) / 2 + 1;
            if (nums[mi] > target) {
                hi = mi - 1;
            } else {
                lo = mi;
            }
        }
        
        if (nums[hi] == target) { ans[1] = hi; }
        
        return ans;
    }
}