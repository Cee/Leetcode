class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int day = 1; day <= k; day++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (flights[j][i] == 1 || i == j) {
                        dp[day][i] = Math.max(dp[day][i], dp[day - 1][j] + days[i][day - 1]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[k][i]);
        }
        return max;
    }
}