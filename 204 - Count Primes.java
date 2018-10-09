class Solution {
    public int countPrimes(int n) {
        if (n <= 2) { return 0; }
        boolean[] nums = new boolean[n];
        Arrays.fill(nums, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (nums[i]) {
                count += 1;
                for (int j = 2; i * j < n; j++) {
                    nums[i * j] = false;
                }
            }
        }
        return count;
    }
}