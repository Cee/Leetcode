class Solution {
    private class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        boolean union(int i, int j) {
            if (i == j) { return false; }
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) { return false; }
            parent[pi] = pj;
            return true;
        }
    }
    
    public boolean validTree(int n, int[][] edges) {
        if (n == 0) { return true; }
        if (edges.length != n - 1) { return false; }
        
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            if (!uf.union(edge[0], edge[1])) {
                return false;
            }
        }
        
        int parent = uf.find(0);
        for (int i = 1; i < n; i++) {
            if (uf.find(i) != parent) {
                return false;
            }
        }
        
        return true;
    }
}