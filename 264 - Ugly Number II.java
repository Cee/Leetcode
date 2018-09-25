class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        // (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
        // (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
        // (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
        // We can find that every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
        for(int i = 1; i < n; i++) {
            int min = Math.min(Math.min(factor2, factor3), factor5);
            ugly[i] = min;
            if (factor2 == min) {
                index2 += 1;
                factor2 = 2 * ugly[index2];
            }
            if (factor3 == min) {
                index3 += 1;
                factor3 = 3 * ugly[index3];
                
            }
            if (factor5 == min) {
                index5 += 1;
                factor5 = 5 * ugly[index5];
            }
        }
        return ugly[n - 1];
    }
}