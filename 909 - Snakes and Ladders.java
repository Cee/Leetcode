class Solution {
//     public int snakesAndLadders(int[][] board) {
//         int n = board.length;
//         int end = n * n;
//         int[] boards = new int[end + 1];
//         int count = 1;
        
//         int i = n - 1; 
//         int j = 0;
//         int dir = 1;
//         while (count <= end) {
//             boards[count] = board[i][j];
//             if (dir == 1 && j + dir == n) { 
//                 i -= 1; 
//                 dir = -1; 
//             } else if (dir == -1 && j + dir == -1) {
//                 i -= 1;
//                 dir = 1;
//             } else {
//                 j += dir;
//             }
//             count += 1;
//         }
//         if (boards[end] != -1) { return -1; }
//         boolean[] visited = new boolean[end + 1];
//         int step = 0;
//         LinkedList<Integer> list = new LinkedList<>();
//         list.offer(1);
//         visited[1] = true;
//         while (!list.isEmpty()) {
//             int size = list.size();
//             step += 1;
//             for (j = 0; j < size; j++) {
//                 int v = list.poll();
//                 if (v + 6 >= end) { return step; }
//                 for (int k = 1; k <= 6 && v + k <= end; k++) {
//                     int q = v + k;
//                     if (visited[q]) { continue; }
//                     if (boards[q] == -1) {
//                         visited[q] = true;
//                         list.offer(q);
//                     } else {
//                         while (boards[q] != -1 && !visited[boards[q]]) {
//                             visited[q] = true;
//                             q = boards[q];
//                             if (q == end) { return step; }
//                         }
//                         list.offer(q);
//                     }
//                 }
//             }
//         }
//         return -1;
//     }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n];
        int i = n - 1, j = 0, index = 0, inc = 1;
        while (index < n * n) {
            arr[index++] = board[i][j];
            if (inc == 1 && j == n - 1) {
                inc = -1;
                i--;
            } else if (inc == -1 && j == 0) {
                inc = 1;
                i--;
            } else {
                j += inc;
            }
        }
        boolean[] visited = new boolean[n * n];
        Queue<Integer> q = new LinkedList<>();
        int start = arr[0] > -1 ? arr[0] - 1 : 0;
        q.offer(start);
        visited[start] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                if (cur == n * n - 1) {
                    return step;
                }
                for (int next = cur + 1; next <= Math.min(cur + 6, n * n - 1); next++) {
                    int dest = arr[next] > -1 ? arr[next] - 1 : next;
                    if (!visited[dest]) {
                        visited[dest] = true;
                        q.offer(dest);
                    }
                }
            }
            step++;
        }
        return -1;
    }
}