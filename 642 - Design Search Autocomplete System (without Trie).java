// https://medium.com/@prefixyteam/how-we-built-prefixy-a-scalable-prefix-search-service-for-powering-autocomplete-c20f98e2eff1
class AutocompleteSystem {

    HashMap<String, HashMap<String, Integer>> prefixHashMap;
    
    public void insert(String s, int times) {
        String str = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            str += c;
            if (!prefixHashMap.containsKey(str)) {
                prefixHashMap.put(str, new HashMap<String, Integer>());
            }
            if (!prefixHashMap.get(str).containsKey(s)) {
                prefixHashMap.get(str).put(s, times);
            } else {
                prefixHashMap.get(str).put(s, prefixHashMap.get(str).get(s) + times);
            }
        }
    }
    
    public Map<String, Integer> lookup(String s) {
        if (prefixHashMap.containsKey(s)) {
            return prefixHashMap.get(s);
        }
        return new HashMap<String, Integer>();
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
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        prefixHashMap = new HashMap<>();
        for (int i = 0; i < sentences.length; i++) {
            insert(sentences[i], times[i]);
        }
    }
    
    String current = "";
    public List<String> input(char c) {
        List<String> res = new ArrayList<>();
        if (c == '#') {
            insert(current, 1);
            current = "";
        } else {
            current = current + c;
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(lookup(current).entrySet());
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