class Solution {
    class Event {
        int id;
        int height;
        int x;
        int type; // 1: entering -1: leaving
        Event(int id, int height, int x, int type) {
            this.id = id;
            this.height = height;
            this.x = x;
            this.type = type;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        List<Event> list = new ArrayList<>();
        int i = 0;
        for (int[] b: buildings) {
            list.add(new Event(i, b[2], b[0], 1));
            list.add(new Event(i, b[2], b[1], -1));
            i++;
        }
        List<int[]> ans = new ArrayList<>();
        Collections.sort(list, (a, b) -> (a.x != b.x ? a.x - b.x : b.type * b.height - a.type * a.height));
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (Event e: list) {
            if (e.type == 1) {
                if (map.isEmpty() || e.height > map.lastKey()) {
                    ans.add(new int[]{ e.x, e.height });
                }
                if (!map.containsKey(e.height)) {
                    map.put(e.height, new HashSet<>());
                }
                map.get(e.height).add(e.id);
            } else {
                map.get(e.height).remove(e.id);
                if (map.get(e.height).isEmpty()) {
                    map.remove(e.height);
                }
                if (!map.isEmpty() && e.height > map.lastKey()) {
                    ans.add(new int[]{ e.x, map.lastKey() });
                } else if (map.isEmpty()) {
                    ans.add(new int[]{ e.x, 0 });
                }
            }
        }
        return ans;
    }
}