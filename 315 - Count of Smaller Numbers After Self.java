class Solution {
    class FenwickTree {
        int[] sum;
        int n;
        FenwickTree(int n) {
            this.n = n;
            sum = new int[n + 1];
        }
        
        void update(int idx, int val) {
            idx += 1;
            while (idx <= n) {
                sum[idx] += val;
                idx += (idx & (onesComplement(idx) + 1));
            }
        }
        
        int sum(int idx) {
            idx += 1;
            int total = 0;
            while (idx > 0) {
                total += sum[idx];
                idx = idx & (idx - 1);
            }
            return total;
        }
        
        int onesComplement(int n) { 
            return ~n & ((Integer.highestOneBit(n) << 1) - 1);
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num: nums) { set.add(num); }
        Map<Integer, Integer> ranks = new HashMap<>();
        int r = 1;
        for (int key: set) { ranks.put(key, r); r++; }
        FenwickTree ft = new FenwickTree(set.size());
        int[] counts = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int rank = ranks.get(nums[i]);
            counts[i] = ft.sum(rank - 1);
            ft.update(rank, 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) { ans.add(counts[i]); }
        return ans;
    }
}