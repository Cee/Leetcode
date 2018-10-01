class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0) { return 0; }
        int sign = 1;
        int ans = 0;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') { i++; }
        if (i >= str.length()) { return 0; }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i += 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && str.charAt(i) > '7')) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            ans = ans * 10 + (str.charAt(i) - '0');
            i += 1;
        }
        return sign * ans;
    }
}