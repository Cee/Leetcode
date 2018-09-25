class MagicDictionary {
    
    class TrieNode {
        boolean isTerminated;
        TrieNode[] children;
        TrieNode() {
            isTerminated = false;
            children = new TrieNode[26];
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() {
            root = new TrieNode();
        }
        
        void insert(String s) {
            TrieNode t = root;
            for (char c: s.toCharArray()) {
                if (t.children[c - 'a'] == null) {
                    t.children[c - 'a'] = new TrieNode();
                }
                t = t.children[c - 'a'];
            }
            t.isTerminated = true;
        }
        
        boolean search(String s) {
            TrieNode t = root;
            for (char c: s.toCharArray()) {
                if (t.children[c - 'a'] == null) { return false; }
                t = t.children[c - 'a'];
            }
            return t.isTerminated;
        }
    }

    Trie t;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        t = new Trie();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String s: dict) {
            t.insert(s);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (ch == c) {
                    continue;
                }
                arr[i] = c;
                if (t.search(String.valueOf(arr))) { return true; }
            }
            arr[i] = ch;
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */