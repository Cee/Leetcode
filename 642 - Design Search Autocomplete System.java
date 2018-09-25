class AutocompleteSystem {

    class TrieNode {
        String sentence;
        int times;
        TrieNode(String sentence, int times) {
            this.sentence = sentence;
            this.times = times;
        }
    }
    
    class Trie {
        int times;
        Trie[] branches = new Trie[27];
    }
    
    public int intValue(char c) {
        return c == ' ' ? 26 : c - 'a';
    }
    
    public void insert(Trie t, String s, int times) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[intValue(s.charAt(i))] == null) {
                t.branches[intValue(s.charAt(i))] = new Trie();
            }
            t = t.branches[intValue(s.charAt(i))];
        }
        t.times += times;
    }
    
    public List<TrieNode> lookup(Trie t, String s) {
        List<TrieNode> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[intValue(s.charAt(i))] == null) {
                return new ArrayList<TrieNode>();
            }
            t = t.branches[intValue(s.charAt(i))];
        }
        traverse(s, t, list);
        return list;
    }
    
    public void traverse(String s, Trie t, List<TrieNode> list) {
        if (t.times > 0) {
            list.add(new TrieNode(s, t.times));
        }
        for (char i = 'a'; i <= 'z'; i++) {
            if (t.branches[i - 'a'] != null) {
                traverse(s + i, t.branches[i - 'a'], list);
            }
        }
        if (t.branches[26] != null) {
            traverse(s + ' ', t.branches[26], list);
        }
    }
    
    Trie root;
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        for (int i = 0; i < sentences.length; i++) {
            insert(root, sentences[i], times[i]);
        }
    }
    
    String current = "";
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(root, current, 1);
            current = "";
        } else {
            current = current + c;
            List<TrieNode> list = lookup(root, current);
            Collections.sort(list, (a, b) -> a.times == b.times ? a.sentence.compareTo(b.sentence) : b.times - a.times);
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                res.add(list.get(i).sentence);
            }
        }
        return res;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */