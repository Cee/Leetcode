class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        visited[0] = true;
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graph, visited, 0, n - 1, curr, ans);
        return ans;
    }
    
    private void dfs(int[][] graph, boolean[] visited, int start, int end, List<Integer> curr, List<List<Integer>> ans) {
        if (start == end) {
            ans.add(new ArrayList<>(curr));
        } else {
            for (int next: graph[start]) {
                if (visited[next] == false) {
                    visited[next] = true;
                    curr.add(next);
                    dfs(graph, visited, next, end, curr, ans);
                    curr.remove(curr.size() - 1);
                    visited[next] = false;
                }
            }
        }
    }
}