class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null || 
            matrix.length == 0 || 
            matrix[0] == null || 
            matrix[0].length == 0) { 
            return ans; 
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = 0;
        int direction = 0; // 0 - right, 1 - down, 2 - left, 3 - up
        
        int count = 0;
        int n = row * col;
        Set<String> visited = new HashSet<>();
        
        while (count < n) {
            ans.add(matrix[i][j]);
            visited.add(rep(i, j));
            count += 1;
            
            switch (direction) {
                case 0: // right
                    if (j + 1 < col && !visited.contains(rep(i, j + 1))) {
                        j = j + 1;
                    } else {
                        direction = 1;
                        i = i + 1;
                    }
                    break;
                case 1: // down
                    if (i + 1 < row && !visited.contains(rep(i + 1, j))) {
                        i = i + 1;
                    } else {
                        direction = 2;
                        j = j - 1;
                    }
                    break;
                case 2: // left
                    if (j - 1 >= 0 && !visited.contains(rep(i, j - 1))) {
                        j = j - 1;
                    } else {
                        direction = 3;
                        i = i - 1;
                    }
                    break;
                case 3: // up
                    if (i - 1 >= 0 && !visited.contains(rep(i - 1, j))) {
                        i = i - 1;
                    } else {
                        direction = 0;
                        j = j + 1;
                    }
                    break;
                default: break;
            }
        }
        
        return ans;
    }
    
    private String rep(int i, int j) {
        return String.valueOf(i) + "," + String.valueOf(j);
    }
}