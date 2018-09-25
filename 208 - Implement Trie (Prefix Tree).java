class Trie {

    class TrieNode {
        boolean isTerminal;
        TrieNode[] children;
        TrieNode() {
            isTerminal = false;
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode t = root;
        for (char c: word.toCharArray()) {
            if (t.children[c - 'a'] == null) {
                t.children[c - 'a'] = new TrieNode();
            }
            t = t.children[c - 'a'];
        }
        t.isTerminal = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode t = root;
        for (char c: word.toCharArray()) {
            if (t.children[c - 'a'] == null) { return false; }
            t = t.children[c - 'a'];
        }
        return t.isTerminal;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode t = root;
        for (char c: prefix.toCharArray()) {
            if (t.children[c - 'a'] == null) { return false; }
            t = t.children[c - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */