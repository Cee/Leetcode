// https://leetcode.com/problems/minimum-cost-to-hire-k-workers/discuss/141768/Detailed-explanation-O(NlogN)
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        double[][] workers = new double[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new double[]{(double)(wage[i]) / quality[i], (double)quality[i]};
        }
        Arrays.sort(workers, (lhs, rhs) -> Double.compare(lhs[0], rhs[0]));
        double ans = Double.MAX_VALUE;
        double qualitySum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (double[] worker: workers) {
            qualitySum += worker[1];
            pq.add(worker[1]);
            if (pq.size() > K) {
                qualitySum -= pq.poll();
            }
            if (pq.size() == K) {
                ans = Math.min(ans, qualitySum * worker[0]);
            }
        }
        return ans;
    }
}