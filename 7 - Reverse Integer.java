class Solution {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) { flag = true; x = -x; }
        long ans = 0;
        while (x > 0) {
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        if (flag) { ans = -ans; }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) { ans = 0; }
        return (int)ans;
    }
}