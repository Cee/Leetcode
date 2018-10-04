class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num: nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int total = left + right + 1;

                max = Math.max(max, total);
                
                map.put(num, total);
                map.put(num - left, total);
                map.put(num + right, total);
            }
        }
        return max;
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>(IntStream.of(nums).boxed().collect(Collectors.toList()));
        int max = 0;
        for (int x: set) {
            if (!set.contains(x - 1)) {
                int y = x + 1;
                while (set.contains(y)) { y++; }
                max = Math.max(max, y - x);
            }
        }
        return max;
    }
}

