class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        if (pattern == null || pattern.length() == 0) { return list; }
        int n = pattern.length();
        char[] pArr = pattern.toCharArray();
        for (String w: words) {
            if (w.length() != n) { continue; }
            HashMap<Character, Character> map = new HashMap<>();
            HashSet<Character> set = new HashSet<>();
            int i = 0;
            for (; i < n; i++) {
                char c = w.charAt(i);
                char p = pArr[i];
                if ((map.containsKey(c) && map.get(c) != p) ||
                    (map.values().contains(p) && !set.contains(c))) {
                    break;
                }
                map.put(c, p);
                set.add(c);
            }
            if (i == n) {
                list.add(w);
            }
        }
        return list;
    }
}