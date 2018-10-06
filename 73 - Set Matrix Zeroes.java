class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
        int col0 = 1;
        int row = matrix.length;
        int col = matrix[0].length;
        
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) { col0 = 0; }
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) { matrix[i][0] = 0; }
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
        int row = matrix.length;
        int col = matrix[0].length;
        long row0 = 0;
        long col0 = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    row0 = row0 | (1 << i);
                    col0 = col0 | (1 << j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                long r = (row0 >> i) & 1;
                long c = (col0 >> j) & 1;
                if ((r == 1) || (c == 1)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}