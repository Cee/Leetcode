class Solution {
//     int[][] dp;
//     public int getMoneyAmount(int n) {
//         dp = new int[n + 1][n + 1];
//         return helper(1, n);
//     }
    
//     private int helper(int start, int end) {
//         if (dp[start][end] != 0) {
//             return dp[start][end];
//         }
//         if (start >= end) {
//             return 0;
//         }
//         if (start >= end - 2) {
//             return dp[start][end] = end - 1;
//         }
//         int mid = (start + end) / 2 - 1, min = Integer.MAX_VALUE;
//         while (mid < end) {
//             int left = helper(start, mid - 1);
//             int right = helper(mid + 1, end);
//             min = Math.min(min, mid + Math.max(left, right));
//             if (right <= left) break;
//             mid++;
//         }
//         return dp[start][end] = min;
//     }
    
    int[][] dp;
    public int getMoneyAmount(int n) {
        dp = new int[n+1][n+1];
        return getMoneyAmount(1, n);
    }

    private int getMoneyAmount(int lower, int upper) {
        if (lower >= upper) {
            return 0;
        }
        if (dp[lower][upper] != 0) {
            return dp[lower][upper];
        }
        if (lower >= upper - 2) {
            return dp[lower][upper] = upper - 1;
        }

        int maximum = Integer.MAX_VALUE;
        for (int i = lower; i <= upper; i++) {
            maximum = Math.min(maximum, Math.max(getMoneyAmount(lower, i - 1), getMoneyAmount(i + 1, upper)) + i);
        }
        dp[lower][upper] = maximum;

        return maximum;
    }
}