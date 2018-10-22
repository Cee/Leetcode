class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            int c1 = n - 1 - i >= 0 ? num1.charAt(n - 1 - i) - '0' : 0;
            int c2 = m - 1 - i >= 0 ? num2.charAt(m - 1 - i) - '0' : 0;
            int c = c1 + c2 + carry;
            if (c >= 10) {
                c -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            ans.append(c);
        }
        if (carry != 0) { ans.append(carry); }
        return ans.reverse().toString();
    }
}