class Solution {
    public double minmaxGasDist(int[] stations, int K) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mi = lo + (hi - lo) / 2.0;
            if (possible(mi, stations, K)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return lo;
    }

    public boolean possible(double D, int[] stations, int K) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; i++) {
            used += (int) ((stations[i+1] - stations[i]) / D);
        }
        return used <= K;
    }
}