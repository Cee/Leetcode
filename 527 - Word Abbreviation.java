class Solution {
    class TrieNode {
        int count;
        TrieNode[] children;
        TrieNode() {
            count = 0;
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        public void insert(String s) {
            TrieNode node = root;
            for (char c: s.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node.children[c - 'a'].count += 1;
                node = node.children[c - 'a'];
            }
        }
        
        public String abbr(String s) {
            if (s.length() <= 3) { return s; }
            
            char[] arr = s.toCharArray();
            int n = s.length();
            int i = 0;
            String abbr = "";
            TrieNode node = root;
            while (i < n - 3) {
                char c = arr[i];
                abbr += c;
                if (node.children[c - 'a'].count == 1) {
                    return abbr + String.valueOf(n - 3 - i + 1) + arr[n - 1];
                }
                node = node.children[c - 'a'];
                i += 1;
            }
            return s;
        }
    }
    
    public List<String> wordsAbbreviation(List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, String> abbrs = new HashMap<>();
        for (String word: dict) {
            String key = rep(word);
            if (key != word) {
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(word);
            } else {
                abbrs.put(word, word);
            }
        }
        for (String key: map.keySet()) {
            if (map.get(key).size() == 1) {
                abbrs.put(map.get(key).get(0), key);
            } else {
                Trie t = new Trie();
                for (String s: map.get(key)) {
                    t.insert(s);
                }
                for (String s: map.get(key)) {
                    abbrs.put(s, t.abbr(s));
                }
            }
        }
        List<String> list = new ArrayList<>();
        for (String word: dict) {
            list.add(abbrs.get(word));
        }
        return list;
    }
    
    private String rep(String s) {
        if (s.length() <= 3) {
            return s;
        }
        return String.valueOf(s.charAt(0)) + String.valueOf(s.length() - 2) + String.valueOf(s.charAt(s.length() - 1));
    }
    
}