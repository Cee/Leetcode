class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) { return 0; }
        int n = s.length();
        char[] arr = s.toCharArray();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        if (arr[0] == '0') { return 0; }
        dp[1] = (long)count(arr[0]);
        for (int i = 1; i < n; i++) {
            int oneChar = count(arr[i]);
            int twoChars = count(arr[i - 1], arr[i]);
            if (oneChar == 0 && twoChars == 0) { return 0; }
            if (oneChar != 0) {
                dp[i + 1] += oneChar * dp[i]; 
            }
            dp[i + 1] %= 1000000007;
            if (twoChars != 0) {
                dp[i + 1] += twoChars * dp[i - 1];
            }
            dp[i + 1] %= 1000000007;
        }
        return (int)(dp[n] % 1000000007);
    }
    
    private int count(char c) {
        if (c == '*') {
            return 9;
        } else if (c == '0') {
            return 0;
        } else {
            return 1;
        }
    }
    
    private int count(char a, char b) {
        if (a == '*') {
            if (b >= '0' && b <= '6') {
                return 2;
            } else if (b >= '7' && b <= '9') {
                return 1;
            } else {
                // b == "*"
                return 15;
            }
        } else if (a == '1') {
            if (b == '*') {
                return 9;
            } else {
                return 1;
            }
        } else if (a == '2') {
            if (b == '*') {
                return 6;
            } else if (b >= '0' && b <= '6') {
                return 1;
            } else {
                return 0;
            }
        } else {
            // a == 0, 3, 4, ..., 9
            return 0;
        }
    }
}