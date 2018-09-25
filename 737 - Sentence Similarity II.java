class Solution {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        
        Map<String, Set<String>> pairInfo = new HashMap<>();      
        for (String[] pair : pairs) {
            if (!pairInfo.containsKey(pair[0])) {
                pairInfo.put(pair[0], new HashSet<>());
            }
            if (!pairInfo.containsKey(pair[1])) {
                pairInfo.put(pair[1], new HashSet<>());
            }            
            pairInfo.get(pair[0]).add(pair[1]);
            pairInfo.get(pair[1]).add(pair[0]);
        }
        
        for (int i = 0; i < words1.length; i++) {
            if (words1[i].equals(words2[i])) continue;         
            if (!pairInfo.containsKey(words1[i])) return false;      
            if (!dfs(words1[i], words2[i], pairInfo, new HashSet<>())) return false;    //Search the graph.
        }        
        return true;
    }
    
    public boolean dfs(String source, String target, Map<String, Set<String>> pairInfo, Set<String> visited) {
        if (pairInfo.get(source).contains(target)) return true;
        
        visited.add(source);
        for (String next : pairInfo.get(source)) {
            if (!visited.contains(next) && dfs(next, target, pairInfo, visited)) {
                return true;
            }
        }
        return false;
    }
}