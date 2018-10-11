class Solution {
    class Tuple {
        int x, y, val;
        Tuple(int x, int y, int val) { 
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < row; i++) {
            pq.offer(new Tuple(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Tuple t = pq.poll();
            if (t.y == col - 1) { continue; }
            pq.offer(new Tuple(t.x, t.y + 1, matrix[t.x][t.y + 1]));
        }
        return pq.peek().val;
    }
}