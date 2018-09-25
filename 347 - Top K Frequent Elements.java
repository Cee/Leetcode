class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new List[nums.length + 1];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for (int key: map.keySet()) {
            buckets[map.get(key)].add(key);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            ret.addAll(buckets[i]);
            if (ret.size() >= k) {
                break;
            }
        }
        return ret;
    }
}