class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return 0; }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] sum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i1 = 0; i1 < row; i1++) {
            for (int j1 = 0; j1 < col; j1++) {
                for (int i2 = i1; i2 < row; i2++) {
                    for (int j2 = j1; j2 < col; j2++) {
                        int ans = sum[i2 + 1][j2 + 1] + sum[i1][j1] - sum[i1][j2 + 1] - sum[i2 + 1][j1];
                        if (ans <= k) {
                            max = Math.max(max, ans);
                        }
                    }
                }
            }
        }
        return max;
    }
}


class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < row; i ++) {
            int[] colSum = new int[col];
            for (int j = i; j < row; j ++) {
                for (int c = 0; c < col; c ++) {
                    colSum[c] += matrix[j][c];
                }
                max = Math.max(max, findMax(colSum, k));
            }
        }
        return max;
    }
    
    private int findMax(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        TreeSet<Integer> s = new TreeSet();
        s.add(0);
    
        for(int i = 0;i < nums.length; i ++){
            int t = sum + nums[i];
            sum = t;
            Integer gap = s.ceiling(sum - k);
            if(gap != null) max = Math.max(max, sum - gap);
            s.add(t);
        }
    
        return max;
    }
}