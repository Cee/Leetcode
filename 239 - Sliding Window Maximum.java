class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) { return nums; }
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && q.peek() < i - k + 1) { q.poll(); }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) { q.pollLast(); }
            q.offer(i);
            if (i >= k - 1) {
                ans[i - k + 1] = nums[q.peek()];
            }
        }
        return ans;
    }
}