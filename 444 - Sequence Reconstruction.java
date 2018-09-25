// https://goo.gl/wnH39i
class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] mapping = new int[n + 1];
        Arrays.fill(mapping, -1);
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            mapping[org[i]] = i; // number -> index
        }
        for (List<Integer> seq: seqs) {
            if (seq.size() == 0) {
                continue;
            }
            int prev = seq.get(0);
            if (prev <= 0 || prev > n || mapping[prev] == -1) {
                return false;
            }
            for (int i = 1; i < seq.size(); i++) {
                int current = seq.get(i);
                if (current <= 0 || current > n || mapping[current] == -1) {
                    return false;
                }
                memo[mapping[prev]] = Math.max(memo[mapping[prev]], n - mapping[current] + 1);
                prev = current;
            }
            memo[mapping[prev]] = Math.max(memo[mapping[prev]], 1);
        }
        for (int i = 0; i < n; i++) {
            if (memo[i] != n - i) {
                return false;
            }
        }
        return true;
    }
}