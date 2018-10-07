class Solution {
    TreeSet<String> set;
    public String orderlyQueue(String S, int K) {
        int n = S.length();
        if (K > n / 2) {
            char[] tempArray = S.toCharArray();
            Arrays.sort(tempArray);
            return new String(tempArray);
        }
        set = new TreeSet<>();
        Deque<String> q = new ArrayDeque<>();
        q.add(S);
        while (!q.isEmpty()) {
            String s = q.poll();
            for (int i = 0; i < K; i++) {
                String t = s.substring(0, i) + s.substring(i + 1) + s.charAt(i);
                if (!set.contains(t)) {
                    set.add(t);
                    q.add(t);
                }
            }
        }
        return set.first();
    }
}