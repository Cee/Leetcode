class NumMatrix {

    int[][] matrix;
    int[][] sum;
    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return; }
        int row = matrix.length;
        int col = matrix[0].length;
        this.matrix = matrix;
        sum = new int[row + 1][col + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + matrix[i][j];
            }
        }
    }
    
    public void update(int row, int col, int val) {
        int delta = val - matrix[row][col];
        matrix[row][col] = val;
        for (int j = col; j < matrix[0].length; j++) {
            sum[row + 1][j + 1] += delta;
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ans = 0;
        for (int i = row1; i <= row2; i++) {
            ans = ans + sum[i + 1][col2 + 1] - sum[i + 1][col1];
        }
        return ans;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */