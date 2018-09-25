// Or use a bucket without tree map.
class Solution {
    public String frequencySort(String s) {
        int[] counts = new int[256];
        for (char c: s.toCharArray()) {
            counts[c] += 1;
        }
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < 256; i++) {
            if (counts[i] > 0) {
                if (!map.containsKey(counts[i])) {
                    map.put(counts[i], new ArrayList<>());
                }
                map.get(counts[i]).add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int key: map.keySet()) {
            for (int c: map.get(key)) {
                for (int i = 0; i < key; i++) {
                    sb.append((char)c);
                }
            }
        }
        return sb.reverse().toString();
    }
}