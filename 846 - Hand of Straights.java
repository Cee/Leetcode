class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null) { return false; }
        int n = hand.length;
        if (n % W != 0) { return false; }
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int c: hand) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        while (map.size() > 0) {
            int first = map.firstKey();
            for (int i = first; i < first + W; i++) {
                if (!map.containsKey(i)) {
                    return false;
                }
                int num = map.get(i);
                if (num == 1) {
                    map.remove(i);
                } else {
                    map.put(i, num - 1);
                }
            }
        }
        
        return true;
    }
}