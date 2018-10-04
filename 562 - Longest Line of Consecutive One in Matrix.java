class Solution {
    public int longestLine(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) { return 0; }
        int row = M.length;
        int col = M[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = M[i][j];
                if (dp[i][j] > 0 && i - 1 >= 0 && dp[i - 1][j] > 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = M[i][j];
                if (dp[i][j] > 0 && j - 1 >= 0 && dp[i][j - 1] > 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = M[i][j];
                if (dp[i][j] > 0 && i - 1 >= 0 && j - 1 >= 0 && dp[i - 1][j - 1] > 0) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dp[i][j] = M[i][j];
                if (dp[i][j] > 0 && i - 1 >= 0 && j + 1 < col && dp[i - 1][j + 1] > 0) {
                    dp[i][j] = dp[i - 1][j + 1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}