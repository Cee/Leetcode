class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int min = 0;
                if (i > 0 && j > 0) {
                    min = Math.min(grid[i][j - 1], grid[i - 1][j]);
                } else if (i > 0) {
                    min = grid[i - 1][j];
                } else if (j > 0){
                    min = grid[i][j - 1];
                }
                grid[i][j] += min;
            }
        }
        return grid[row - 1][col - 1];
    }
}