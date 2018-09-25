class Solution {
    public int racecar(int target) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 1}); // starts from position 0 with speed 1

        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + 1);

        for (int level = 0; !queue.isEmpty(); level++) {
            for (int k = queue.size(); k > 0; k--) {
                int[] cur = queue.poll();  // cur[0] is position; cur[1] is speed

                if (cur[0] == target) {
                    return level;
                }

                int[] nxt = new int[] {cur[0] + cur[1], cur[1] << 1};  // accelerate instruction
                String key = (nxt[0] + " " + nxt[1]);

                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    queue.offer(nxt);
                    visited.add(key);
                }

                nxt = new int[] {cur[0], cur[1] > 0 ? -1 : 1};  // reverse instruction
                key = (nxt[0] + " " + nxt[1]);

                if (!visited.contains(key) && 0 < nxt[0] && nxt[0] < (target << 1)) {
                    queue.offer(nxt);
                    visited.add(key);
                }
            }
        }

        return -1;
    }
}