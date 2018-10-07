class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        int[] max = new int[26];
        for (String b: B) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c: b.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
                max[c - 'a'] = Math.max(max[c - 'a'], map.get(c));
            }
        }
        
        List<String> ans = new ArrayList<>();
        for (String a: A) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c: a.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean valid = true;
            for (char c = 'a'; c <= 'z'; c++) {
                if (max[c - 'a'] > 0 && (!map.containsKey(c) || map.get(c).intValue() < max[c - 'a'])) {
                    // System.out.println(c);
                    valid = false;
                    break;
                }
            }
            if (valid) {
                ans.add(a);
            }
        }

        return ans;
    }
}