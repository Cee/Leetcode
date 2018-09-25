class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int ans = 0;
        while (n > 0) {
            if (n % 2 == 1) { ans += 1; }
            n >>= 1;
        }
        return ans;
    }
}