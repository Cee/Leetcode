class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        List<Set<Integer>> blocks = new ArrayList<>();
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            blocks.add(new HashSet<Integer>());
            rows.add(new HashSet<Integer>());
            cols.add(new HashSet<Integer>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '0';
                    if (blocks.get(block(i, j)).contains(k)) { return false; }
                    if (rows.get(i).contains(k)) { return false; }
                    if (cols.get(j).contains(k)) { return false; }
                    blocks.get(block(i, j)).add(k);
                    rows.get(i).add(k);
                    cols.get(j).add(k);
                }
            }
        }
        return true;
    }
    
    private int block(int i, int j) {
        return 3 * (i / 3) + (j / 3);
    }
}