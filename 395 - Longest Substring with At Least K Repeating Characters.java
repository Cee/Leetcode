class Solution {
    public int longestSubstring(String s, int k) {
        int len = 0; 
        for (int i = 0; i < 26; i++) {
            int[] count = new int[26];
            int lo = 0;
            int hi = 0;
            int unique = 0;
            while (hi < s.length()) {
                boolean valid = true;
                if (count[s.charAt(hi) - 'a'] == 0) {
                    unique += 1;
                }
                count[s.charAt(hi) - 'a'] += 1;
                hi += 1;
                
                // Make it valid
                while (unique > i) {
                    if (count[s.charAt(lo) - 'a'] == 1) {
                        unique -= 1;
                    }
                    count[s.charAt(lo) - 'a'] -= 1;
                    lo += 1;
                }
                
                for (int j = 0; j < 26; j++) {
                    if (count[j] > 0 && count[j] < k) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    len = Math.max(len, hi - lo);
                }
            }
        }
        return len; 
    }
}