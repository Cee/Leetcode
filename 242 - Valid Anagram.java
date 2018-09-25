class Solution {
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) { return true; }
        if (s == null && t != null) { return false; }
        if (s != null && t == null) { return false; }
        if (s.length() != t.length()) { return false; }
        int n = s.length();
        int[] count = new int[26];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) { return false; }
        }
        return true;
    }
}