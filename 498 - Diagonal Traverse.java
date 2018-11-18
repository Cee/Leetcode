class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return new int[0]; }
        int row = matrix.length;
        int col = matrix[0].length;
        int x = 0;
        int y = 0;
        int count = 0;
        int[] ans = new int[row * col];
        int[][] dirs = {{-1, 1}, {1, -1}};
        int d = 0;
        while (count < row * col) {
            ans[count] = matrix[x][y];
            x += dirs[d][0];
            y += dirs[d][1];
            
            if (x >= row) { x = row - 1; y += 2; d = 1 - d; }
            if (y >= col) { y = col - 1; x += 2; d = 1 - d; }
            if (x < 0)  { x = 0; d = 1 - d;}
            if (y < 0)  { y = 0; d = 1 - d;}
            count += 1;
        }
        return ans;
    }
}