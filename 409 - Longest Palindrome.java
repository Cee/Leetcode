class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = 0;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            int count = (int)entry.getValue();
            if (count % 2 == 0) {
                ans += count;
                it.remove();
            } else {
                ans += count - 1;
                map.put((char)entry.getKey(), 1);
            }
        }
        return map.isEmpty() ? ans : ans + 1;
    }
}