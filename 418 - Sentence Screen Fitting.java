class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for (String s: sentence) {
            sb.append(s).append(" ");
        }
        String s = sb.toString();
        int start = 0;
        int n = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % n) == ' ') { 
                start += 1; 
            } else {
                while (start > 0 && s.charAt((start - 1) % n) != ' ') {
                    start -= 1;
                }
            }
        }
        return start / n;
    }
}