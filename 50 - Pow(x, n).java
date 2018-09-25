class Solution {
    public double myPow(double x, int n) {
        long m = n;
        if (m < 0) {
            x = 1 / x;
            m = -m;
        }
        double ans = 1;
        double p = x;
        while (m > 0) {
            if (m % 2 == 1) {
                ans *= p;
            }
            p *= p;
            m >>= 1;
        }
        return ans;
    }
}