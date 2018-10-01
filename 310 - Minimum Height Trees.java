class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        if (n == 1) { ans.add(0); return ans; }
        int[] degree = new int[n];
        for (int i = 0; i < n; i++) { graph.add(new ArrayList<>()); }
        for (int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            degree[edge[0]] += 1;
            graph.get(edge[1]).add(edge[0]);
            degree[edge[1]] += 1;
        }
        
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) { q.offer(i); }
        }
        
        while (!q.isEmpty()) {
            ans = new ArrayList<>();
            int size = q.size();
            
            while (size-- > 0) {
                int curr = q.poll();
                ans.add(curr);
                degree[curr] -= 1;
                for (int next: graph.get(curr)) {
                    if (degree[next] == 0) { continue; }
                    degree[next] -= 1;
                    if (degree[next] == 1) {
                        q.offer(next);
                    }
                }
            }
        }
        
        return ans;
    }
}