class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) { return true; }
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            while (lo < hi && 
                   !((s.charAt(lo) >= 'a' && s.charAt(lo) <= 'z') || 
                     (s.charAt(lo) >= 'A' && s.charAt(lo) <= 'Z') ||
                     (s.charAt(lo) >= '0' && s.charAt(lo) <= '9'))) {
                lo += 1;
            }
            while (lo < hi && 
                   !((s.charAt(hi) >= 'a' && s.charAt(hi) <= 'z') || 
                     (s.charAt(hi) >= 'A' && s.charAt(hi) <= 'Z') ||
                     (s.charAt(hi) >= '0' && s.charAt(hi) <= '9'))) {
                hi -= 1;
            }
            if (lo < hi && !(s.charAt(lo) == s.charAt(hi) 
                            || (s.charAt(lo) >= 'a' && s.charAt(lo) <= 'z' && s.charAt(lo) - 'a' + 'A' == s.charAt(hi))
                            || (s.charAt(lo) >= 'A' && s.charAt(lo) <= 'Z' && s.charAt(lo) - 'A' + 'a' == s.charAt(hi)))) { 
                return false; 
            }
            lo += 1;
            hi -= 1;
        }
        return true;
    }
}