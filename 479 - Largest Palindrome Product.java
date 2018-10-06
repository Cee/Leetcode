class Solution {
    public int largestPalindrome(int n) {
        if (n == 1) { return 9; }
        
        long max = (long)Math.pow(10, n) - 1;
        long min = max / 10 + 1;
        
        for (long i = max; i >= min; i--) {
            long left = i;
            long right = 0;
            long j = left;
            while (j != 0) {
                right = right * 10 + j % 10;
                j = j / 10;
                left = left * 10;
            }
            long palindrome = left + right;
            
            for (long k = max; k >= min; k--) {
                long div = palindrome / k;
                if (div > k) { break; }
                if (palindrome % k == 0) { return (int)(palindrome % 1337); }
            }
        }
        
        return 0; // Error
    }
}