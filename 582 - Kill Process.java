class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            int p = pid.get(i);
            int pp = ppid.get(i);
            if (!map.containsKey(pp)) { map.put(pp, new HashSet<>()); }
            map.get(pp).add(p);
        }
        List<Integer> list = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(kill);
        while (!q.isEmpty()) {
            int p = q.poll();
            list.add(p);
            if (map.containsKey(p)) { q.addAll(map.get(p)); }
        }
        return list;
    }
}