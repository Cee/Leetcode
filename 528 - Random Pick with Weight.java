import java.util.Random;

class Solution {

    List<Integer> sums;
    Random r;
    int sum;
    int n;
    public Solution(int[] w) {
        sums = new ArrayList<>();
        sum = 0;
        n = w.length;
        r = new Random(System.currentTimeMillis());
        for (int x: w) {
            sum += x;
            sums.add(sum);
        }
    }
    
    public int pickIndex() {
        int idx = r.nextInt(sum);
        int lo = 0;
        int hi = n - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (idx >= sums.get(mi)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */