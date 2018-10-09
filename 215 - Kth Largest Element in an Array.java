class Solution {
    public int findKthLargest(int[] nums, int k) {
        return nums[quickSelect(nums, 0, nums.length - 1, nums.length - k + 1)]; 
    }
    
    private int quickSelect(int[] arr, int lo, int hi, int idx) {
        int left = lo;
        int right = hi;
        int pivot = arr[hi];
        while (left < right) {
            if (arr[left] > pivot) {
                right -= 1;
                swap(arr, left, right);
            } else {
                left += 1;
            }
        }
        swap(arr, left, hi);
        int n = left - lo + 1;
        if (n == idx) { return left; }
        if (n > idx) { return quickSelect(arr, lo, left - 1, idx); }
        return quickSelect(arr, left + 1, hi, idx - n);
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}