class Solution {
    public int[] numberOfLines(int[] widths, String S) {
        int MAX_WIDTH = 100;
        int width = 0;
        int lines = 1;
        for (char c: S.toCharArray()) {
            int charWidth = widths[c - 'a'];
            if (width + charWidth > MAX_WIDTH) {
                width = 0;
                lines += 1;
            }
            width += charWidth;
        }
        return new int[]{lines, width};
    }
}