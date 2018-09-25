class Solution {
    public int smallestRangeI(int[] A, int K) {
        Arrays.sort(A);
        if (A[0] + K >= A[A.length - 1] - K) { return 0; }
        return A[A.length - 1] - K - A[0] - K;
    }
}