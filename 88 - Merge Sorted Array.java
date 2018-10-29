class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        int p = m - 1;
        int q = n - 1;
        while (p >= 0 && q >= 0) {
            int x = nums1[p];
            int y = nums2[q];
            if (x > y) { 
                nums1[pos] = x; 
                p -= 1; 
            } else {
                nums1[pos] = y;
                q -= 1;
            }
            pos -= 1;
        }
        while (q >= 0) {
            nums1[pos] = nums2[q];
            q -= 1;
            pos -= 1;
        }
    }
}