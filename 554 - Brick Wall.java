class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        for (List<Integer> w: wall) {
            int sum = 0;
            for (int l: w) {
                sum += l;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            map.remove(sum);
        }
        int min = n;
        for (int v: map.keySet()) {
            min = Math.min(min, n - map.get(v));
        }
        return min;
    }
}