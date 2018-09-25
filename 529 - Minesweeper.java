public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];
            
            if (board[row][col] == 'M') { // Mine
                board[row][col] = 'X';
            }
            else { // Empty
                // Get number of mines first.
                int count = 0;
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                    }
                }
                
                if (count > 0) { // If it is not a 'B', stop further BFS.
                    board[row][col] = (char)(count + '0');
                }
                else { // Continue BFS to adjacent cells.
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) continue;
                            int r = row + i, c = col + j;
                            if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                            if (board[r][c] == 'E') {
                                queue.add(new int[] {r, c});
                                board[r][c] = 'B'; // Avoid to be added again.
                            }
                        }
                    }
                }
            }
        }
        
        return board;
    }
}

// class Solution {
//     public char[][] updateBoard(char[][] board, int[] click) {
//         int row = board.length;
//         int col = board[0].length;
//         int x = click[0];
//         int y = click[1];
        
//         if (board[x][y] == 'M') {
//             board[x][y] = 'X';
//             return board;
//         }
//         Set<String> visited = new HashSet<>();
//         Queue<int[]> q = new LinkedList<>();
//         Queue<int[]> temp = new LinkedList<>();
//         q.offer(new int[]{x, y});
//         while (!q.isEmpty()) {
//             int[] pos = q.poll();
//             x = pos[0];
//             y = pos[1];
//             visited.add(x + " " + y);
//             int count = 0;
//             for (int i = -1; i <= 1; i++) {
//                 for (int j = -1; j <= 1; j++) {
//                     if (x + i >= 0 && x + i < row && y + j >= 0 && y + j < col) {
//                         if (board[x + i][y + j] == 'M') { count += 1; }
//                         if (board[x + i][y + j] == 'E' && 
//                             !visited.contains((x + i) + " " + (y + j))) { temp.offer(new int[]{x + i, y + j}); }
//                     }
//                 }
//             }
//             if (count == 0) { 
//                 board[x][y] = 'B'; 
//                 q.addAll(temp);
//             } else {
//                 board[x][y] = (char)('0' + count);
//             }
//             temp.clear();
//         }
//         return board;
//     }
// }