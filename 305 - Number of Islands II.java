class Solution {
    class UnionFind {
        int[] parent;
        int count;
        UnionFind(int n) {
            parent = new int[n];
            count = 0;
            Arrays.fill(parent, -1);
        }
        
        void mark(int i) {
            parent[i] = i;
        }
        
        int find(int i) {
            if (parent[i] == -1) { return -1; }
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        void union(int i, int j) {
            int m = find(i);
            int n = find(j);
            if (m != n) {
                parent[m] = n;
            }
        }
        
        int count() {
            int ans = 0;
            for (int i = 0; i < parent.length; i++) {
                if (find(i) == i) {
                    ans += 1;
                }
            }
            return ans;
        }
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind uf = new UnionFind(m * n);
        List<Integer> list = new ArrayList<>();
        int[] delta = new int[]{-1, 0, 1, 0, -1}; 
        if (positions == null || positions.length == 0 || positions[0].length == 0) { return list; }
        for (int[] pos: positions) {
            int x = pos[0], y = pos[1];
            uf.mark(x * n + y);
            for (int i = 0; i < 4; i++) {
                int dx = x + delta[i], dy = y + delta[i + 1];
                if (dx < 0 || dx >= m || dy < 0 || dy >= n) { continue; }
                if (uf.parent[dx * n + dy] != -1) {
                    uf.union(x * n + y, dx * n + dy);
                }
            }
            list.add(uf.count());
        }
        return list;
    }
}