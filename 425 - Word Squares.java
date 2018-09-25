class Solution {
    List<List<String>> ans;
    public List<List<String>> wordSquares(String[] words) {
        ans = new ArrayList<>();
        if (words == null || words.length == 0) { return ans; }

        int n = words.length;
        int length = words[0].length();
        String prefix = "";
        dfs(words, n, length, prefix, new ArrayList<String>());
        return ans;
    }
    
    private void dfs(String[] words, int n, int k, String prefix, List<String> current) {
        if (current.size() == k) {
            List<String> cur = new ArrayList<>(current);
            ans.add(cur);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (words[j].startsWith(prefix)) {
                current.add(words[j]);
                String p = "";
                if (current.size() < k) {
                    for (int idx = 0; idx < current.size(); idx++) {
                        p = p + current.get(idx).charAt(current.size());
                    }
                }
                dfs(words, n, k, p, current);
                current.remove(current.size() - 1);
            }
        }
    }
}