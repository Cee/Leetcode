class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        int count = 0;
        for (char c: tasks) {
            map[c - 'A']++;
            count = Math.max(count, map[c - 'A']);
        }
        int ans = (n + 1) * (count - 1);
        for (int m: map) {
            if (m == count) ans++;
        }
        return Math.max(tasks.length, ans);
    }
}