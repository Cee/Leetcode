class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 1;
        while (n > 0) {
            int c = a;
            a = a + b;
            b = c;
            n -= 1;
        }
        return b;
    }
}