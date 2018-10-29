class Solution {
    HashSet<String> islands;
    String s;
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) { return 0; }
        int row = grid.length;
        int col = grid[0].length;
        islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    s = new String();
                    dfs(grid, i, j, row, col);
                    // System.out.println(i + " " + j + " " + s);
                    // if (!islands.contains(s)) {
                        islands.add(s);
                    // }
                }
            }
        }
        return islands.size();
    }
    
    private void dfs(int[][] grid, int i, int j, int row, int col) {
        grid[i][j] = 0;
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + delta[k];
            int y = j + delta[k + 1];
            if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0) { continue; }
            s = s + k + ",";
            dfs(grid, x, y, row, col);
            s = s + k + ",";
        }
    }
}