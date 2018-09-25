class AutocompleteSystem {

    // HashMap<String, HashMap<String, Integer>> prefixHashMap;
    
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
        Map<String, Integer> completions = new HashMap<>();
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
            if (t.completions.containsKey(s)) {
                t.completions.put(s, t.completions.get(s) + times);
            } else {
                t.completions.put(s, times);
            }
            t = t.branches[intValue(s.charAt(i))];
        }
        if (t.completions.containsKey(s)) {
            t.completions.put(s, t.completions.get(s) + times);
        } else {
            t.completions.put(s, times);
        }
        t.times += times;
    }
    
    public Map<String, Integer> lookup(Trie t, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (t.branches[intValue(s.charAt(i))] == null) {
                return new HashMap<String, Integer>();
            }
            t = t.branches[intValue(s.charAt(i))];
        }
        return t.completions;
    }
    
    public class ValueThenKeyComparator<K extends Comparable<? super K>, V extends Comparable<? super V>>
        implements Comparator<Map.Entry<K, V>> {

        public int compare(Map.Entry<K, V> a, Map.Entry<K, V> b) {
            int cmp1 = b.getValue().compareTo(a.getValue());
            if (cmp1 != 0) {
                return cmp1;
            } else {
                return a.getKey().compareTo(b.getKey());
            }
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
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(lookup(root, current).entrySet());
            Collections.sort(list, new ValueThenKeyComparator<String, Integer>());
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                res.add(list.get(i).getKey());
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