class Solution {
    public int titleToNumber(String s) {
        int base = (int)Math.pow(26, s.length() - 1);
        int ans = 0;
        for (char c: s.toCharArray()) {
            ans += base * (c - 'A' + 1);
            base /= 26;
        }
        return ans;
    }
}