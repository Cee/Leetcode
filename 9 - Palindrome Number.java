class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) { return false; }
        int n = x;
        int m = 0;
        while (n > 0) {
            m = m * 10 + n % 10;
            n = n / 10;
        }
        return m == x;
    }
}