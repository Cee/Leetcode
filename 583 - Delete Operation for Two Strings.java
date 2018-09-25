class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null && word2 == null) { return 0; }
        if (word1.length() == 0 && word2.length() == 0) { return 0; }
        if (word1.length() == 0 && word2.length() != 0) { return word2.length(); }
        if (word1.length() != 0 && word2.length() == 0) { return word1.length(); }
        
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        
        return n + m - 2 * dp[n][m];
    }
}