class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) { return 0; }
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(0);
        visited.add(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int i = q.poll();
                if (i + nums[i] >= n - 1) { return step + 1; }
                for (int j = nums[i]; j >= 1; j--) {
                    if (!visited.contains(i + j)) {
                        q.offer(i + j);
                        visited.add(i + j);
                    }
                }
                size--;
            }
            step += 1;
        }
        return 0;
    }
}