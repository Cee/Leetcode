class Solution {
    public String addBinary(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder ans = new StringBuilder();
        int carry = 0;
        for (int i = 0; i < Math.max(n, m); i++) {
            int c1 = n - 1 - i >= 0 ? a.charAt(n - 1 - i) - '0' : 0;
            int c2 = m - 1 - i >= 0 ? b.charAt(m - 1 - i) - '0' : 0;
            int c = c1 + c2 + carry;
            if (c >= 2) {
                c -= 2;
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