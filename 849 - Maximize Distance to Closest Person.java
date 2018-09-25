class Solution {
    public int maxDistToClosest(int[] seats) {
        if (seats == null || seats.length == 0) { return 0; }
        int n = seats.length;
        int max = Integer.MIN_VALUE;
        int count = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                if (prev == -1) {
                    max = Math.max(max, count);
                }
                max = Math.max(max, (i - prev) / 2);
                prev = i;
                count = 0;
            } else {
                count += 1;
            }
        }
        if (count != 0 && prev != -1) {
            max = Math.max(max, count);
        }
        return max;
    }
}