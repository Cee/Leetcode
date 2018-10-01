class Solution {
    public int uniquePaths(int m, int n) {
        if (n > m) { int tmp = n; n = m; m = tmp; }
        long ans = 1;
        for (int i = 1; i < n; i++) {
            ans *= m;
            m += 1;
        }
        for (int i = 1; i < n; i++) {
            ans /= i;
        }
        return (int)ans;
    }
}