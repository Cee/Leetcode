class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) { return 0; }
        int row = grid.length;
        int col = grid[0].length;
        int[] rowMax = new int[row];
        int[] colMax = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                colMax[j] = Math.max(colMax[j], grid[i][j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += Math.min(rowMax[i], colMax[j]) - grid[i][j];
            }
        }
        return sum;
    }
}