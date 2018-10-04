class Solution {
    int count;
    int max;
    public int maxAreaOfIsland(int[][] grid) {
        count = 0;
        max = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return max; }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    dfs(grid, i, j);
                }
            }
        }
        return max;
    }
    
    private void dfs(int[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) { return; }
        if (grid[x][y] == 0) { return; }
        grid[x][y] = 0;
        count += 1;
        max = Math.max(count, max);
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + delta[i], y + delta[i + 1]);
        }
    }
}