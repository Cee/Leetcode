class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) { return true; }
        int n = s.length();
        for (int i = n / 2; i > 0; i--) {
            if (n % i != 0) { continue; }
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n / i; j++) {
                sb.append(s.substring(0, i));
            }
            if (sb.toString().equals(s)) { return true; }
        }
        return false;
    }
}