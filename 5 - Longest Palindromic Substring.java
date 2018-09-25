class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) { return s; }
        int n = s.length();
        int max = 0;
        int start = 0;
        int end = 0;
        String longest = "";
        for (int i = 0; i < n; i++) {
            int j = 1;
            while (i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j)) { 
                if (1 + 2 * j > max) {
                    max = 1 + 2 * j;
                    start = i - j;
                    end = i + j;
                }
                j += 1; 
            }
            
            j = 0;
            while (i - j >= 0 && i + 1 + j < n && s.charAt(i - j) == s.charAt(i + j + 1)) { 
                if (2 + j * 2 > max) {
                    max = 2 + j * 2;
                    start = i - j;
                    end = i + 1 + j;
                }
                j += 1; 
            }   
        }
        return s.substring(start, end + 1);
    }
//     public String longestPalindrome(String s) {
//         if (s == null || s.length() < 1) return "";
//         int start = 0, end = 0;
//         for (int i = 0; i < s.length(); i++) {
//             int len1 = expandAroundCenter(s, i, i);
//             int len2 = expandAroundCenter(s, i, i + 1);
//             int len = Math.max(len1, len2);
//             if (len > end - start) {
//                 start = i - (len - 1) / 2;
//                 end = i + len / 2;
//             }
//         }
//         return s.substring(start, end + 1);
//     }

//     private int expandAroundCenter(String s, int left, int right) {
//         int L = left, R = right;
//         while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
//             L--;
//             R++;
//         }
//         return R - L - 1;
//     }
}