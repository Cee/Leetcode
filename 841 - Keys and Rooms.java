class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) { set.add(i); }
        LinkedList<Integer> queue = new LinkedList<>();
        
        queue.offer(0);
        while (!queue.isEmpty()) {
            int room = queue.poll();
            set.remove(room);
            List<Integer> connected = rooms.get(room);
            for (int r: connected) {
                if (set.contains(r)) {
                    queue.offer(r);
                }
            }
        }
        
        return set.isEmpty();
    }
}