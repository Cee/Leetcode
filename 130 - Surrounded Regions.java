class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) { return; }
        Set<Integer> set = new HashSet<>();
        
        int n = board.length;
        int m = board[0].length;
        
        char[][] visited = new char[n][];
        for (int i = 0; i < n; i++) {
            visited[i] = board[i].clone();
        }
        
        for (int j = 0; j < m; j++) {
            if (visited[0][j] == 'O') {
                dfs(visited, 0, j, n, m, set);
            }
            if (visited[n - 1][j] == 'O') {
                dfs(visited, n - 1, j, n, m, set);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (visited[i][0] == 'O') {
                dfs(visited, i, 0, n, m, set);
            }
            if (visited[i][m - 1] == 'O') {
                dfs(visited, i, m - 1, n, m, set);
            }
        }
        
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (board[i][j] == 'O' && !set.contains(pos(i, j, m))) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private int pos(int i, int j, int m) {
        return i * m + j;
    }
    
    private void dfs(char[][] visited, int i, int j, int n, int m, Set<Integer> set) {
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] == 'X') { return; }
        set.add(pos(i, j, m));
        visited[i][j] = 'X';
        dfs(visited, i - 1, j, n, m, set);
        dfs(visited, i + 1, j, n, m, set);
        dfs(visited, i, j - 1, n, m, set);
        dfs(visited, i, j + 1, n, m, set);
    }
}