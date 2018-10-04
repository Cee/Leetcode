class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) { return ""; }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            int j = 0;
            while (j < prefix.length() && j < s.length() &&
                   prefix.charAt(j) == s.charAt(j)) {
                j += 1;
            }
            prefix = prefix.substring(0, j);
            if (prefix.length() == 0) { break; }
        }
        return prefix;
    }
}