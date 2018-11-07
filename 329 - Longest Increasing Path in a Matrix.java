class Solution {
    int[] delta = new int[]{-1, 0, 1, 0, -1};
    int row, col;
    int[][] cache;
    
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
        row = matrix.length;
        col = matrix[0].length;
        cache = new int[row][col];
        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (cache[i][j] != 0) { return cache[i][j]; }
        for (int k = 0; k < 4; k++) {
            int x = i + delta[k];
            int y = j + delta[k + 1];
            if (0 <= x && x < row && 0 <= y && y < col && matrix[x][y] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, x, y));
            }
        }
        cache[i][j] += 1;
        return cache[i][j];
    }
}