class Solution {
    public int knightDialer(int N) {
        long[] ans = new long[10];
        long MOD = 1_000_000_007;
        for (int i = 0; i < 10; i++) { ans[i] = 1; }
        if (N == 1) { return 10; }
        for (int i = 2; i <= N; i++) {
            long[] temp = new long[10];
            temp[0] = (ans[4] + ans[6]) % MOD;
            temp[1] = (ans[6] + ans[8]) % MOD;
            temp[2] = (ans[7] + ans[9]) % MOD;
            temp[3] = (ans[4] + ans[8]) % MOD;
            temp[4] = (ans[0] + ans[3] + ans[9]) % MOD;
            temp[5] = 0;
            temp[6] = (ans[0] + ans[1] + ans[7]) % MOD;
            temp[7] = (ans[2] + ans[6]) % MOD;
            temp[8] = (ans[1] + ans[3]) % MOD;
            temp[9] = (ans[2] + ans[4]) % MOD;
            ans = temp;
        }
        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + ans[i]) % MOD;
        }
        return (int)sum;
    }
}