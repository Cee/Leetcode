class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        int pos = lo;
        lo = 0;
        hi = nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int actualMid = (mid + pos) % nums.length;
            if (nums[actualMid] == target) { return actualMid; }
            if (nums[actualMid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;   
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        int pos = lo;
        lo = pos;
        hi = pos + nums.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid % nums.length] == target) { return mid % nums.length; }
            if (nums[mid % nums.length] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;   
            }
        }
        return -1;
    }
}