class Solution {
    public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        while (n >= 2) {
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < n / 2; i++) {
                String s1 = list.get(i);
                String s2 = list.get(n - 1 - i);
                String s = "(" + s1 + "," + s2 + ")";
                ans.add(s);
            }
            list = ans;
            n >>= 1;
        }
        return list.get(0);
    }
}