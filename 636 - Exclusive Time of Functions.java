class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        LinkedList<Integer> starts = new LinkedList<>();
        for (String s: logs) {
            String[] splits = s.split(":");
            int id = Integer.valueOf(splits[0]);
            int time = Integer.valueOf(splits[2]);
            if (splits[1].equals("start")) {
                starts.offer(time);
            } else {
                int start = starts.removeLast();
                int delta = time - start + 1;
                ans[id] += delta;
                int size = starts.size();
                while (size > 0) {
                    starts.offer(starts.removeFirst() + delta);
                    size--;
                }
            }
        }
        return ans;
    }
}