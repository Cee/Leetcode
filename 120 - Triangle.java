class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) { return 0; }
        int n = triangle.size();
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            int prev = Integer.MAX_VALUE;
            for (int j = 0; j <= i; j++) {
                int curr = j == i ? Integer.MAX_VALUE : dp[j];
                dp[j] = Math.min(prev, curr) + triangle.get(i).get(j);
                prev = curr;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) { min = Math.min(min, dp[i]); }
        return min;
    }
}