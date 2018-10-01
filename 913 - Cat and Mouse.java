class Solution {
    
    private int min(int[][] dis, boolean[] visited, int k) {
        int x = Integer.MAX_VALUE;
        int y = -1;
        for (int i = 0; i < dis.length; i++) {
            if (!visited[i] && dis[k][i] < x) {
                y = i;
                x = dis[k][i];
            }
        }
        return y;
    }
    
    public int catMouseGame(int[][] graph) {
        int n = graph.length;
        int[][] dis = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) { 
                    dis[i][j] = 0; 
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for (int k = 0; k < n; k++) {
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                int next = min(dis, visited, k);
                visited[next] = true;
                for (int v: graph[next]) {
                    int d = dis[k][next] + 1;
                    if (dis[k][v] > d) {
                        dis[k][v] = d;
                    }
                }
            }
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            for (int v: graph[i]) {
                set.add(v);
            }
            map.put(i, set);
        }

        Set<String> set = new HashSet<>();
        int mouse = 1;
        int cat = 2;
        set.add(mouse + " " + cat);
        while (true) {
            // Mouse
            int mChoice = -1;
            int min = Integer.MAX_VALUE;
            
            if (dis[mouse][0] == 1) { return 1; }
            boolean lose = true;
            for (int next: map.get(mouse)) {
                if (dis[next][cat] >= 2) {
                    lose = false;
                    break;
                }
            }
            if (lose) { return 2; }
            
            if (map.get(mouse).size() == 1) {
                Iterator iter = map.get(mouse).iterator();
                mChoice = (int)iter.next();
            } else {
                for (int next: map.get(mouse)) {
                    if (dis[next][cat] >= 2 && dis[0][next] < min) {
                        mChoice = next;
                        min = dis[0][next];
                    }
                }
            }
            if (mChoice == 0) { return 1; }
            mouse = mChoice;
            
            // Cat
            int cChoice = -1;
            int min0 = Integer.MAX_VALUE;
            int minMouse = Integer.MAX_VALUE;
            if (map.get(cat).size() == 1) {
                Iterator iter = map.get(cat).iterator();
                cChoice = (int)iter.next();
            } else {
                for (int next: map.get(cat)) {
                    if (next == 0) { continue; }
                    if (map.get(mouse).contains(next)) {
                        if (dis[0][next] < min0) {
                            cChoice = next;
                            min0 = dis[0][next];
                            minMouse = dis[next][mouse];
                        }
                    } else {
                        if (dis[next][mouse] < minMouse) {
                            cChoice = next;
                            min0 = dis[0][next];
                            minMouse = dis[next][mouse];
                        } else if (dis[next][mouse] == minMouse) {
                            // Look ahead
                            for (int mouseNext: map.get(mouse)) {
                                if (dis[0][mouseNext] == 1 && dis[next][mouseNext] == 1) {
                                    cChoice = next;
                                    min0 = dis[0][next];
                                    minMouse = dis[next][mouse];
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            if (cChoice == mouse) { return 2; }
            cat = cChoice;
            
            String s = mouse + " " + cat;
            if (set.contains(s)) break;
            set.add(s);
        }
        return 0;
    }
}