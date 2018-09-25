class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    helper(grid, i, j, n, m);
                    count += 1;
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) { return; }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            helper(grid, i + 1, j, n, m);
            helper(grid, i - 1, j, n, m);
            helper(grid, i, j + 1, n, m);
            helper(grid, i, j - 1, n, m);
        }
    }
}