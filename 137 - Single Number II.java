class Solution {
    public int singleNumber(int[] nums) {
        int[] digit = new int[32];
        for (int num: nums) {
            int n = num;
            for (int j = 31; j >= 0; j--) {
                digit[j] += n & 1;
                n >>= 1;
                if (n == 0) { break; }
            }
        }
        int res = 0;
        for (int j = 31; j >= 0; j--) {
            int n = digit[j] % 3;
            res += (n << (31 - j));
        }
        return res;
    }
}