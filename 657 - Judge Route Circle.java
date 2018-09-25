class Solution {
    public boolean judgeCircle(String moves) {
        if (moves == null || moves.length() == 0) { return true; }
        char[] arr = moves.toCharArray();
        int x = 0, y = 0;
        for (char c: arr) {
            if (c == 'U') {
                y -= 1;
            } else if (c == 'D') {
                y += 1;
            } else if (c == 'L') {
                x -= 1;
            } else if (c == 'R') {
                x += 1;
            }
        }
        
        return (x == 0) && (y == 0);
    }
}