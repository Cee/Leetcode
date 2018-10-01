class Solution {
    class UnionFind {
        int[] parent;
        int[] count;
        UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }
        
        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        void union(int i, int j) {
            int m = find(i);
            int n = find(j);
            if (m != n) {
                parent[m] = n;
                count[n] += count[m];
            }
        }
    }
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m * n + 1);
        for (int[] hit: hits) {
            int x = hit[0], y = hit[1];
            if (grid[x][y] == 1) { grid[x][y] = 2; }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, uf);
                }
            }
        }
        int count = uf.count[uf.find(0)];
        int[] res = new int[hits.length];
        
        for (int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0], y = hits[i][1];
            if (grid[x][y] == 2) {
                dfs(grid, x, y, uf);
                grid[x][y] = 1;
            }
            int newCount = uf.count[uf.find(0)];
            res[i] = (newCount - count > 0) ? newCount - count - 1 : 0;
            count = newCount;
        }
        return res;
    }
    
    private void dfs(int[][] grid, int x, int y, UnionFind uf) {
        int m = grid.length;
        int n = grid[0].length;
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int dx = x + delta[i];
            int dy = y + delta[i + 1];
            if (dx < 0 || dx >= m || dy < 0 || dy >= n) { continue; }
            if (grid[dx][dy] == 1) {
                uf.union(x * n + y + 1, dx * n + dy + 1);
            }
        }
        if (x == 0) {
            uf.union(x * n + y + 1, 0);
        }
    }
}