class Solution {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) { return false; }
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j] && search(board, word, i, j, row, col, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
        
    private boolean search(char[][] board, String word, int i, int j, int row, int col, int index) {
        if (index == word.length()) { return true; }
        if (i < 0 || i >= row || j < 0 || j >= col) { return false; }
        if (board[i][j] != word.charAt(index)) { return false; }
        if (visited[i][j]) { return false; }
        
        visited[i][j] = true;
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            if (search(board, word, i + delta[k], j + delta[k + 1], row, col, index + 1)) {
                return true;
            }    
        }
        
        visited[i][j] = false;
        
        return false;
    }
}