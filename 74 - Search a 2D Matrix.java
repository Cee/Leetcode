class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) { return false; }
        int row = matrix.length;
        int col = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[row - 1][col - 1]) { return false; }
        
        int lo = 0;
        int hi = row * col - 1;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (matrix[mi / col][mi % col] == target) {
                return true;
            }
            if (matrix[mi / col][mi % col] < target) {
                lo = mi + 1;
            } else {
                hi = mi - 1;
            }
        }
        return false;
    }
}