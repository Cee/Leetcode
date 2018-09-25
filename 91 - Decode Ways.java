class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) { return 0; }
        int n = s.length();
        char[] arr = s.toCharArray();
        if (arr[0] == '0') { return 0; }
        int[] dp = new int[n + 1];
        dp[0] = 1; dp[1] = 1;
        for (int i = 1; i < n; i++) {
            boolean oneChar = valid(arr[i]);
            boolean twoChars = valid(arr[i - 1], arr[i]);
            if (!oneChar && !twoChars) { return 0; }
            if (twoChars) {
                dp[i + 1] += dp[i - 1];
            } 
            if (oneChar) {
                dp[i + 1] += dp[i];
            }
        }
        return dp[n];
    }
    
    private boolean valid(char a, char b) {
        if (a == '0') {
            return false;
        } else if (a == '1') {
            return true;
        } else if (a == '2') {
            return (b - '0' >= 0 && b - '0' <= 6);
        } else {
            return false;
        }
    }
    
    private boolean valid(char a) {
        return a != '0';
    }
}