class Solution {
    class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int n) {
            while (parent[n] != n) {
                parent[n] = parent[parent[n]];
                n = parent[n];
            }
            return n;
        }
        
        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) { return; }
            parent[pa] = pb;
        }
        
        int count() {
            int count = 0;
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == i) { count += 1; }
            }
            return count;
        }
    }
    
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge: edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count();
    }
}