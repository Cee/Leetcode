class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: deck) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = -1;
        for (int key: map.keySet()) {
            if (ans == -1) {
                ans = map.get(key);
            } else {
                ans = gcd(ans, map.get(key));
                if (ans < 2) { return false; }
            }
        }
        return ans >= 2;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) { return a; }
        return gcd(b, a % b);
    }
}