class Solution {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        Map<Integer, Set<Integer>> r = new HashMap<>();
        Map<Integer, Set<Integer>> s = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            r.put(i, new HashSet<>());
            for (int j = 0; j < routes[i].length; j++) {
                int stop = routes[i][j];
                r.get(i).add(stop);
                if (!s.containsKey(stop)) {
                    s.put(stop, new HashSet<>());
                }
                s.get(stop).add(i);
            }
        }
        if (!s.containsKey(S) || !s.containsKey(T)) { return -1; }
        if (S == T) { return 0; }
        LinkedList<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for (int route: s.get(S)) {
            q.offer(route);
            visited.add(route);
        }
        int count = 0;
        while (!q.isEmpty()) {
            count += 1;
            int size = q.size();
            while (size > 0) {
                int route = q.poll();
                for (int stop: r.get(route)) {
                    if (stop == T) { return count; }
                    if (s.containsKey(stop)) {
                        for (int next: s.get(stop)) {
                            if (!visited.contains(next)) {
                                q.offer(next);
                                visited.add(next);
                            }
                        }
                        s.remove(stop);
                    }
                }
                size -= 1;
            }
        }
        return -1;
    }
}