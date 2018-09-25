class Solution {
    public int romanToInt(String s) {
        int[] values = new int[26];
        values['I' - 'A'] = 1;
        values['V' - 'A'] = 5;
        values['X' - 'A'] = 10;
        values['L' - 'A'] = 50;
        values['C' - 'A'] = 100;
        values['D' - 'A'] = 500;
        values['M' - 'A'] = 1000;
        
        int ans = 0;
        if (s == null || s.length() == 0) { return ans; }
        ans = values[s.charAt(0) - 'A'];
        for (int i = 1; i < s.length(); i++) {
            ans += values[s.charAt(i) - 'A'];
            if (values[s.charAt(i - 1) - 'A'] < values[s.charAt(i) - 'A']) {
                ans -= 2 * values[s.charAt(i - 1) - 'A'];
            }
        }
        return ans;
    }
}