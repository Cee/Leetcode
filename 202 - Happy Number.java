class Solution {
    public boolean isHappy(int n) {
        if (n <= 0) { return false; }
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n)) { return false; }
            set.add(n);
            int ans = 0;
            while (n > 0) {
                int m = n % 10;
                ans += m * m;
                n = n / 10;
            }
            n = ans;
        }
        return true;
    }
}