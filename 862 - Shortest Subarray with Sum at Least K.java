class Solution {
    public int shortestSubarray(int[] A, int K) {
        if (A == null || A.length == 0) { return 0; }
        int n = A.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (long)A[i];
        }
        int ans = n + 1;
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n + 1; i++) {
            while (!q.isEmpty() && sum[i] <= sum[q.getLast()]) {
                q.removeLast();
            }
            while (!q.isEmpty() && sum[i] >= sum[q.peek()] + K) {
                ans = Math.min(ans, i - q.peek());
                q.poll();
            }
            q.offer(i);
        }
        return ans == n + 1 ? -1: ans;
    }
}