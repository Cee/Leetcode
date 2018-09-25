class Solution {
    
    List<String> res;
    boolean[] visited;
    
    public List<String> generateAbbreviations(String word) {
        res = new ArrayList<>();
        if (word == null) { return res; }
        if (word.length() == 0) { 
            res.add("");
            return res;
        }
        int n = word.length();
        visited = new boolean[n];
        char[] arr = word.toCharArray();
        dfs(arr, n, 0);
        return res;
    }
    
    private void dfs(char[] arr, int n, int i) {
        if (i == n) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (visited[j]) {
                    count += 1;
                } else {
                    if (count != 0) {
                        sb.append(String.valueOf(count));
                        count = 0;
                    }
                    sb.append(arr[j]);
                }
            }
            if (count != 0) {
                sb.append(String.valueOf(count));
                count = 0;
            }
            res.add(sb.toString());
            return;
        }
        
        visited[i] = false;
        dfs(arr, n, i + 1);
        visited[i] = true;
        dfs(arr, n, i + 1);
    }
}