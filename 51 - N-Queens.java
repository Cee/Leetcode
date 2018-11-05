class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        res = new ArrayList<>();
        dfs(board, 0, n);
        return res;
    }
    
    private void dfs(char[][] board, int colIndex, int n) {
        if (colIndex == n) {
            res.add(construct(board));
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (validate(board, i, colIndex, n)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, n);
                board[i][colIndex] = '.';
            }
        }
    }
    
    private boolean validate(char[][] board, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}