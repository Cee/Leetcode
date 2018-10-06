class Solution {
    class TrieNode {
        TrieNode[] children;
        int index;
        List<Integer> indices;
        TrieNode() {
            children = new TrieNode[26];
            index = -1;
            indices = new ArrayList<>();
        }
    }
    
    class Trie {
        TrieNode root;
        Trie() { root = new TrieNode(); }
        
        void insert(String s, int index) {
            TrieNode r = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                int c = s.charAt(i) - 'a';
                if (r.children[c] == null) {
                    r.children[c] = new TrieNode();
                }
                if (isPalindrome(s, 0, i)) {
                    r.indices.add(index);
                }
                
                r = r.children[c];
            }
            r.indices.add(index);
            r.index = index;
        }
        
        void search(String s, int index, List<List<Integer>> ans) {
            TrieNode r = root;
            for (int i = 0; i < s.length(); i++) {
                if (r.index != -1 && r.index != index &&
                    isPalindrome(s, i, s.length() - 1)) {
                    ans.add(Arrays.asList(index, r.index));
                }
                r = r.children[s.charAt(i) - 'a'];
                if (r == null) { return; }
            }
            for (int j: r.indices) {
                if (index == j) { continue; }
                ans.add(Arrays.asList(index, j));
            }
        }
        
        boolean isPalindrome(String s, int i, int j) {
            while (i < j) {
                if (s.charAt(i) != s.charAt(j)) { return false; }
                i++; j--;
            }
            return true;
        }
    }
    
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Trie t = new Trie();
        for (int i = 0; i < words.length; i++) {
            t.insert(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            t.search(words[i], i, ans);
        }
        return ans;
    }
}