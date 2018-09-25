class Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) { return "0"; }
        int n = num1.length();
        int m = num2.length();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int[] ans = new int[n + m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[n - 1 + m - 1 - (i + j)] += (n1[i] - '0') * (n2[j] - '0');
            }
        }
        for (int i = 0; i < n + m; i++) {
            if (i < n + m - 1) {
                ans[i + 1] = ans[i + 1] + (ans[i] / 10);
            }
            ans[i] = ans[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        int i = n + m - 1;
        while (i >= 0 && ans[i] == 0) { i--; }
        for (int j = i; j >= 0; j--) { sb.append(ans[j]); }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}