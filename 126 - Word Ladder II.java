class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) { return list; }
        Set<String> words = new HashSet<>(wordList);
                
        Map<String, List<String>> graph = new HashMap();
        Set<String> curLevel = new HashSet();
        
        curLevel.add(beginWord);
        boolean foundEnd = false;
        
        while (!curLevel.isEmpty() && !foundEnd) {
            words.removeAll(curLevel);  //this is important for minimizing the graph size, and avoid backtrack of the path
            Set<String> nextLevel = new HashSet();
            for (String s : curLevel) {
                graph.put(s, new ArrayList<String>());
                char[] cur = s.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char c = cur[j];
                    for (char r = 'a'; r <= 'z'; r++) {
                        if (r == c) continue;
                        cur[j] = r;
                        String temp = new String(cur);
                        if (!words.contains(temp)) continue;
                        graph.get(s).add(temp);
                        nextLevel.add(temp);
                        if (temp.equals(endWord)) {
                            foundEnd = true;
                        }
                    }
                    cur[j] = c;
                }
            }
            curLevel = nextLevel;
        }
        if (!foundEnd) { return list; }
        List<String> curr = new ArrayList<>();
        curr.add(beginWord);
        dfs(beginWord, endWord, list, graph, curr);
        return list;
    }
    
    private void dfs(String from, String to, 
                     List<List<String>> list, 
                     Map<String, List<String>> graph, 
                     List<String> curr) {
        if (from.equals(to)) {
            list.add(new ArrayList(curr));
            return;
        }
        if (!graph.containsKey(from)) {
            return;
        }
        for (String next: graph.get(from)) {
            curr.add(next);
            dfs(next, to, list, graph, curr);
            curr.remove(curr.size() - 1);
        }
    }
}

// TLE

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> list = new ArrayList<>();
        
        Map<String, Set<String>> neighbours = new HashMap<>();
        
        if (!wordList.contains(endWord)) { return list; }
        Set<String> words = new HashSet<>(wordList);
        int minLength = ladderLength(beginWord, endWord, words, neighbours);
        if (minLength == -1) { return list; }
        
        System.out.println(minLength);
        
        List<String> curr = new ArrayList<String>();
        curr.add(beginWord);
        dfs(beginWord, endWord, curr, list, neighbours);
        return list;
    }
    
    private void dfs(String beginWord, String endWord,
                     List<String> curr, List<List<String>> ans, Map<String, Set<String>> neighbours) {
        if (endWord.equals(beginWord)) {
            ans.add(new ArrayList<String>(curr));
        } else {
            if (neighbours.containsKey(beginWord)) {   
                for (String s: neighbours.get(beginWord)) {
                    curr.add(s);
                    dfs(s, endWord, curr, ans, neighbours);
                    curr.remove(curr.size() - 1);
                }
            }
        }   
    }
    
    private int ladderLength(String beginWord, String endWord, Set<String> words, Map<String, Set<String>> neighbours) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 0;
        int ans = -1;
        while (!q.isEmpty() && ans == -1) {
            len += 1;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String word = q.poll();
                if (!neighbours.containsKey(word)) { neighbours.put(word, new HashSet<>()); }
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) { continue; }
                        arr[j] = c;
                        String s = String.valueOf(arr);
                        if (!neighbours.containsKey(s)) { neighbours.get(word).add(s); }
                        if (s.equals(endWord)) { ans = len + 1; }
                        if (words.contains(s) && !visited.contains(s)) {
                            q.offer(s);
                            visited.add(s);
                        }
                    }
                    arr[j] = old;
                }
            }
        }
        return ans;
    }
}