class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null) { return 0; }
        int ans = 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    ans += 4;
                    for (int k = 0; k < 4; k++) {
                        int r = i + dirs[k];
                        int c = j + dirs[k + 1];
                        if (r >= 0 && c >= 0 && 
                            r < row && c < col && 
                            grid[r][c] == 1) {
                            ans -= 1;
                        }
                    }
                }
            }
        }
        return ans;
    }
}