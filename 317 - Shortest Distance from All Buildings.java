class Solution {
    class Tuple {
        int y;
        int x;
        int dist;
        Tuple(int y, int x, int dist) {
            this.y = y;
            this.x = x;
            this.dist = dist;
        }
    }
    
    int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        // Initialize building list and accessibility matrix `grid`
        List<Tuple> buildings = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    buildings.add(new Tuple(i, j, 0));
                }
                grid[i][j] = -grid[i][j];
            }
        }
        // BFS from every building
        for (int k = 0; k < buildings.size(); ++k) {
            bfs(buildings.get(k), k, dist, grid, m, n);
        }
        // Find the minimum distance
        int ans = -1;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == buildings.size() && (ans < 0 || dist[i][j] < ans)) {
                    ans = dist[i][j];
                }
            }
        }
        return ans;
    }

    public void bfs(Tuple root, int k, int[][] dist, int[][] grid, int m, int n) {
        LinkedList<Tuple> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tuple b = q.poll();
            dist[b.y][b.x] += b.dist;
            for (int i = 0; i < 4; ++i) {
                int x = b.x + dx[i], y = b.y + dy[i];
                if (y >= 0 && x >= 0 && y < m && x < n && grid[y][x] == k) {
                    grid[y][x] = k + 1;
                    q.add(new Tuple(y, x, b.dist + 1));
                }
            }
        }
    }
    
}