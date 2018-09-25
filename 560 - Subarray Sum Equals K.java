class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) { return 0; }
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int count = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int sum: sums) {
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}