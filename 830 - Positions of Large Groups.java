class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ans = new ArrayList<>();
        if (S == null || S.length() <= 2) { return ans; }
        int i = 0, j = 0;
        while (j < S.length()) {
            while (j < S.length() && S.charAt(i) == S.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j - 1);
                ans.add(pair);
            }
            i = j;
        }
        return ans;
    }
}