class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        if (A == null || A.length == 0)  { return 0; }
        int n = A.length;
        int[] sums = new int[n + 1];
        int sum = 0;
        sums[0] += 1;
        for (int i: A) {
            sum += i;
            sums[sum] += 1;
        }
        if (sum < S) { return 0; }
        int ans = 0;
        for (int i = sum; i >= S; i--) {
            int j = i - S;
            if (j != i) {
                ans += sums[j] * sums[i];
            } else {
                ans += sums[i] * (sums[i] - 1) / 2;
            }
        }
        return ans;
    }
}