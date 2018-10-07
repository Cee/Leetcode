class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int ans = A[0];
        int sum = A[0];
        // 1 interval
        for (int i = 1; i < n; i++) {
            sum = Math.max(sum + A[i], A[i]);
            ans = Math.max(ans, sum);
        }
        
        int[] rightSum = new int[n];
        int[] rightMax = new int[n];
        rightSum[n - 1] = A[n - 1];
        rightMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + A[i];
            rightMax[i] = Math.max(rightSum[i], rightMax[i + 1]);
        }
        
        // 2 intervals
        int leftSum = 0;
        for (int i = 0; i < n - 2; i++) {
            leftSum += A[i];
            ans = Math.max(ans, leftSum + rightMax[i + 2]);
        }
        
        return ans;
    }
}