class Solution {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] index = new int[26];
        Arrays.fill(index, s.length());
        for (int i = 0; i < s.length(); i++) {
            if (index[s.charAt(i) - 'a'] == s.length()) {
                index[s.charAt(i) - 'a'] = i;
            } else if (index[s.charAt(i) - 'a'] >= 0 && index[s.charAt(i) - 'a'] < s.length()) {
                index[s.charAt(i) - 'a'] = -1;
            }
        }
        int min = s.length();
        for (int i = 0; i < 26; i++) {
            if (index[i] >= 0 && index[i] < s.length()) {
                min = Math.min(min, index[i]); 
            }
        }
        
        return min == s.length() ? -1 : min;
    }
}