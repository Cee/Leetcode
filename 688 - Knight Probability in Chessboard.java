class Solution {
    public double knightProbability(int N, int K, int r, int c) {
        int[][] dirs = new int[][]{{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        double[][][] dp = new double[K + 1][N][N];
        dp[0][r][c] = 1;
        for (int step = 1; step <= K; step++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int[] dir: dirs) {
                        int x = dir[0] + i;
                        int y = dir[1] + j;
                        if (x < 0 || x >= N || y < 0 || y >= N) continue;
                        dp[step][i][j] += dp[step - 1][x][y] * 0.125;
                    }
                }
            }
        }
        double res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                res += dp[K][i][j];
            }
        }
        return res;
    }
}