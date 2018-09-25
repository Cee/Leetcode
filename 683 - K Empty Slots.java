class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int n = flowers.length;
        if (n == 0 || k >= n) {
            return -1;
        }
        k += 1;
        int slots = (n + k - 1) / k;
        int[] min = new int[slots];
        int[] max = new int[slots];
        Arrays.fill(min, Integer.MAX_VALUE);
        Arrays.fill(max, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            int x = flowers[i] - 1;
            int p = x / k;
            if (x < min[p]) {
                min[p] = x;
                if (p > 0 && max[p - 1] == x - k) {
                    return i + 1;
                }
            }
            if (x > max[p]) {
                max[p] = x;
                if (p < slots - 1 && min[p + 1] == x + k) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
}