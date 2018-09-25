class Solution {
    class TrieNode {
        boolean terminal;
        TrieNode[] children;
        TrieNode() {
            terminal = false;
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
            t.terminal = true;
        }
        
        boolean valid(String s) {
            TrieNode t = root;
            for (char c: s.toCharArray()) {
                if (t.children[c - 'a'] == null || t.children[c - 'a'].terminal == false) {
                    return false;
                }
                t = t.children[c - 'a'];
            }
            return t.terminal;
        }
    }
    
    public String longestWord(String[] words) {
        Trie t = new Trie();
        for (String s: words) {
            t.insert(s);
        }
        String ans = "";
        for (String s: words) {
            if (t.valid(s)) {
                if (s.length() > ans.length() || (s.length() == ans.length() && s.compareTo(ans) < 0)) {
                    ans = s;
                }
            }
        }
        return ans;
    }
}