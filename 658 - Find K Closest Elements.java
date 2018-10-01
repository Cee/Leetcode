class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (x - arr[mi] > arr[mi + k] - x) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) { ans.add(arr[lo + i]); }
        return ans;
    }
}