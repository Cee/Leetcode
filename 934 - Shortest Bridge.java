class Solution {
    class Pos {
        int x, y;
        Pos(int x, int y) { this.x = x; this.y = y; }
    }
    boolean[][] visited;
    LinkedList<Pos> q;
    public int shortestBridge(int[][] A) {
        int n = A.length;
        visited = new boolean[n][n];
        q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new Pos(i, j));
                    dfs(A, i, j, n);
                    found = true;
                    break;
                }
            }
            if (found) { break; }
        }
        int move = 1;
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                Pos p = q.poll();
                int i = p.x;
                int j = p.y;
                // System.out.println(i + " " + j);
                for (int k = 0; k < 4; k++) {
                    int x = i + delta[k];
                    int y = j + delta[k + 1];
                    if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        q.offer(new Pos(x, y));
                        if (A[x][y] == 1) { return move - 1; }
                    }
                }
                size -= 1;
            }
            move += 1;
        }
        return move - 1;
    }
    
    private void dfs(int[][] A, int i, int j, int n) {
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + delta[k];
            int y = j + delta[k + 1];
            if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && A[x][y] == 1) {
                visited[x][y] = true;
                q.offer(new Pos(x, y));
                dfs(A, x, y, n);
            }
        }
    }
}