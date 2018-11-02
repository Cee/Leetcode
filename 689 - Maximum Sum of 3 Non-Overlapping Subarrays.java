class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Prefix sum
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        int[] left = new int[n];
        int max = sum[k] - sum[0];
        for (int i = k; i < n; i++) {
            left[i] = left[i - 1];
            if (sum[i + 1] - sum[i + 1 - k] > max) {
                left[i] = i + 1 - k; // [i - k + 1, i]
                max = sum[i + 1] - sum[i + 1 - k];
            }
        }
        
        int[] right = new int[n];
        right[n - k] = n - k; // [n - k, n - 1]
        max = sum[n] - sum[n - k];
        for (int i = n - k - 1; i >= 0; i--) {
            right[i] = right[i + 1];
            if (sum[i + k] - sum[i] > max) {
                right[i] = i; // [i, i + k - 1]
                max = sum[i + k] - sum[i];
            }
        }
        
        max = 0;
        int[] ans = new int[3];
        for (int i = k; i <= n - 2 * k; i++) {
            int l = left[i - 1];
            int r = right[i + k];
            int s = (sum[l + k] - sum[l]) + (sum[i + k] - sum[i]) + (sum[r + k] - sum[r]);
            if (s > max) {
                max = s;
                ans[0] = l;
                ans[1] = i;
                ans[2] = r;
            }
        }
        
        return ans;
    }
}