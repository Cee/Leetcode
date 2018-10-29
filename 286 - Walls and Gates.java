class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) { return; }
        int row = rooms.length;
        int col = rooms[0].length;
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rooms[i][j] == 0) {
                    visited.add(i * col + j);
                    q.offer(i * col + j);
                }
            }
        }
        int[] delta = new int[]{-1, 0, 1, 0, -1};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int pos = q.poll();
                int x = pos / col;
                int y = pos % col;
                for (int i = 0; i < 4; i++) {
                    int dx = x + delta[i];
                    int dy = y + delta[i + 1];
                    if (dx >= 0 && dx < row && dy >= 0 && dy < col && 
                        rooms[dx][dy] != -1 && !visited.contains(dx * col + dy)) {
                        visited.add(dx * col + dy);
                        q.offer(dx * col + dy);
                    }
                }
                rooms[x][y] = step;
                size -= 1;
            }
            step += 1;
        }
    }
}