class Solution {
    class Tuple {
        int x, y, val;
        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> l = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0 || k == 0) { return l; }
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (int i = 0; i < m; i++) {
            pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));
        }
        for (int i = 1; i <= Math.min(k, m * n); i++) {
            Tuple t = pq.poll();
            l.add(new int[]{ nums1[t.x], nums2[t.y] });
            if (t.x == n - 1) { continue; }
            pq.offer(new Tuple(t.x + 1, t.y, nums1[t.x + 1] + nums2[t.y]));
        }
        return l;
    }
}