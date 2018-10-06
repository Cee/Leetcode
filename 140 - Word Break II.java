class Solution {
    
    HashMap<Integer, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return wordBreak(s, new HashSet<>(wordDict), 0);
    }
    
    public List<String> wordBreak(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = wordBreak(s, wordDict, end);
                for (String l: list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }
}