class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        int[] memo = new int[paths.length + 1];
        int maxLen = 0;
        for (String s: paths) {
            int lev = s.lastIndexOf("\t") + 1;
            memo[lev + 1] = memo[lev] + s.length() - lev + 1;
            if (s.contains(".")) maxLen = Math.max(maxLen, memo[lev + 1] - 1);
        }
        return maxLen;
    }
}