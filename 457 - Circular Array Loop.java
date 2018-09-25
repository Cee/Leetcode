class Solution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length == 0) { return false; }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0 && dfs(i, 0, n, nums) != 0) {
                return true;
            }
        }
        return false;
    }
    
    private int dfs(int index, int count, int n, int[] nums) {
        if (count < n) {
            int nextIndex = (index + nums[index] + n) % n;
            if (nextIndex == index 
                || nums[nextIndex] + nums[index] <= 0 
                || dfs(nextIndex, count + 1, n, nums) == 0) {
                nums[index] = 0;
            }
        }
        return nums[index];
    }
}