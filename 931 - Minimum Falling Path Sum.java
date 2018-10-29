class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = A[i - 1][j];
                if (j - 1 >= 0) { min = Math.min(min, A[i - 1][j - 1]); }
                if (j + 1 < n) { min = Math.min(min, A[i - 1][j + 1]); } 
                A[i][j] += min;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) { min = Math.min(min, A[n - 1][j]); }
        return min;
    }
}