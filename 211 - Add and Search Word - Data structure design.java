class WordDictionary {
    
    class TrieNode {
        boolean isTerminal;
        TrieNode[] children;
        TrieNode() {
            isTerminal = false;
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        void add(String s) {
            TrieNode t = root;
            for (char c: s.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                t = t.children[c - 'a'];
            }
            t.isTerminal = true;
        }
        
        boolean search(String s) {
            return search(s, 0, root);
        }
        
        private boolean search(String s, int idx, TrieNode t) {
            char c = s.charAt(idx);
            if (idx == s.length() - 1) {
                if (c == '.') {
                    for (int i = 0; i < 26; i++) {
                        if (t.children[i] != null && t.children[i].isTerminal) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    return t.children[c - 'a'] != null && t.children[c - 'a'].isTerminal;
                }
            }
            if (c == '.') {
                for (int i = 0; i < 26; i++) {
                    if (t.children[i] != null && search(s, idx + 1, t.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                return t.children[c - 'a'] != null && search(s, idx + 1, t.children[c - 'a']);
            }
        }
    }

    Trie t;
    /** Initialize your data structure here. */
    public WordDictionary() {
        t = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        t.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return t.search(word);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */