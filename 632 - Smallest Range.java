class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        int n = nums.size();
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i).get(index[i]);
            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }
            map.get(num).add(i);
        }
        int min = map.firstKey();
        int max = map.lastKey();
        while (true) {
            int currMin = map.firstKey();
            List<Integer> groups = map.get(currMin);
            map.remove(currMin);
            boolean reachesEnd = false;
            for (int group: groups) {
                if (index[group] == nums.get(group).size() - 1) {
                    reachesEnd = true;
                    break;
                }
                index[group] += 1;
                int num = nums.get(group).get(index[group]);
                if (!map.containsKey(num)) {
                    map.put(num, new ArrayList<>());
                }
                map.get(num).add(group);
            }
            if (reachesEnd) { break; }
            currMin = map.firstKey();
            int currMax = map.lastKey();
            if (currMax - currMin < max - min) {
                max = currMax;
                min = currMin;
            }
        }
        return new int[]{ min, max };
    }
}