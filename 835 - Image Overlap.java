class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n = A.length;
        
        int max = 0;
        for (int oi = -(n - 1); oi < n; oi++) {
            for (int oj = -(n - 1); oj < n; oj++) {
                int match = 0;
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i + oi >= 0 && j + oj >= 0 &&
                            i + oi < n && j + oj < n &&
                            A[i][j] == B[i + oi][j + oj] && A[i][j] == 1) {
                            match += 1;
                        } 
                    }
                }
                max = Math.max(match, max);
            }
        }
        
        return max;
    }
}