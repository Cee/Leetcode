class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) { return; }
        int row = board.length;
        int col = board[0].length;
        // 0 1 current
        // 00, 01, 10, 11 next
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int count = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    for (int dy = -1; dy <= 1; dy++) {
                        if (!(dx == 0 && dy == 0) && 
                            i + dx >= 0 && i + dx < row &&
                            j + dy >= 0 && j + dy < col &&
                            board[i + dx][j + dy] % 2 == 1) {
                            count += 1;
                        }
                    }
                }
                if ((board[i][j] == 1 && count >= 2 && count <= 3) || (board[i][j] == 0 && count == 3)) {
                    board[i][j] += 2;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
}