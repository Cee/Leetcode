class Solution {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() == 0) { return ""; }
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (char c: map.keySet()) {
            pq.add(new int[]{ c, map.get(c) });
        }
        LinkedList<int[]> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            sb.append((char)first[0]);
            first[1] -= 1;
            q.offer(first);
            
            if (q.size() < k) { continue; }
            
            int[] next = q.poll();
            if (next[1] > 0) {
                pq.offer(next);
            }
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}