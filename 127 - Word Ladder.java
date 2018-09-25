class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) { return 0; }
        Set<String> words = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 0;
        while (!q.isEmpty()) {
            len += 1;
            int n = q.size();
            for (int i = 0; i < n; i++) {
                String word = q.poll();
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char old = arr[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (old == c) { continue; }
                        arr[j] = c;
                        String s = String.valueOf(arr);
                        if (s.equals(endWord)) { return len + 1; }
                        if (words.contains(s) && !visited.contains(s)) {
                            q.offer(s);
                            visited.add(s);
                        }
                    }
                    arr[j] = old;
                }
            }
        }
        return 0;
    }
}