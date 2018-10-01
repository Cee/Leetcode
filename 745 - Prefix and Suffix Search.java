class WordFilter {
    
    class TrieNode {
        boolean isTerminal;
        TrieNode[] children;
        Set<String> words;
        TrieNode() {
            isTerminal = false;
            children = new TrieNode[26];
            words = new HashSet<>();
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        void insertPrefix(String word) {
            TrieNode t = root;
            for (char c: word.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                t.words.add(word);
                t = t.children[c - 'a'];
            }
            t.words.add(word);
            t.isTerminal = true;
        }
        
        void insertSuffix(String word) {
            TrieNode t = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char c = word.charAt(i);
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                t.words.add(word);
                t = t.children[c - 'a'];
            }
            t.words.add(word);
            t.isTerminal = true;
        }
        
        Set<String> searchPrefix(String prefix) {
            TrieNode t = root;
            if (prefix == null || prefix.length() == 0) {
                return t.words;
            }
            for (char c: prefix.toCharArray()) {
                if (t.children[c - 'a'] == null) { return new HashSet<String>(); }
                t = t.children[c - 'a'];
            }
            return t.words;
        }
        
        Set<String> searchSuffix(String suffix) {
            TrieNode t = root;
            if (suffix == null || suffix.length() == 0) {
                return t.words;
            }
            for (int i = suffix.length() - 1; i >= 0; i--) {
                char c = suffix.charAt(i);
                if (t.children[c - 'a'] == null) { return new HashSet<String>(); }
                t = t.children[c - 'a'];
            }
            return t.words;
        }
    }
    
    Trie prefixTrie;
    Trie suffixTrie;
    Map<String, Integer> index;
    public WordFilter(String[] words) {
        prefixTrie = new Trie();
        suffixTrie = new Trie();
        index = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            index.put(word, i);
            prefixTrie.insertPrefix(word);
            suffixTrie.insertSuffix(word);
        }
    }
    
    public int f(String prefix, String suffix) {
        Set<String> prefixSet = prefixTrie.searchPrefix(prefix);
        Set<String> suffixSet = suffixTrie.searchSuffix(suffix);
        String ans = "";
        for (String s: prefixSet) {
            if (suffixSet.contains(s)) {
                if (s.length() > ans.length()) {
                    ans = s;
                } else if (s.length() == ans.length() && index.get(s) > index.get(ans)) {
                    ans = s;
                }
            }
        }
        return ans.length() == 0 ? -1 : index.get(ans);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */