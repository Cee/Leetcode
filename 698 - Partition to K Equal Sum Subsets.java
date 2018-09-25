class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null) { return false; }
        
        int n = nums.length;
        if (n < k) { return false; }
        
        int sum = 0;
        for (int num: nums) {
            sum += num;
        }
        
        if (sum % k != 0) { return false; }
        int target = sum / k;
        
        Arrays.sort(nums);
        if (nums[n - 1] > target) { return false; }
        
        int[] sums = new int[k];
        
        return dfs(nums, sums, target, k, n - 1, n);
    }
    
    private boolean dfs(int[] nums, int[] sums, int target, int k, int i, int n) {
        if (i < 0) { return true; }

        int num = nums[i];
        for (int l = 0; l < k; l++) {
            if (sums[l] + num <= target) {
                sums[l] += num;
                if (dfs(nums, sums, target, k, i - 1, n)) {
                    return true;
                }
                sums[l] -= num;
            } 
        }
        
        return false;
    }
}