class Solution {
    List<String> ans;
    public List<String> removeInvalidParentheses(String s) {
        ans = new ArrayList<>();
        remove(s, 0, 0, new char[]{'(', ')'});
        return ans;
    }
    
    private void remove(String s, int lo, int hi, char[] par) {
        int count = 0;
        for (int i = lo; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) { count += 1; }
            if (s.charAt(i) == par[1]) { count -= 1; }
            if (count >= 0) { continue; }
            // Need remove
            for (int j = hi; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == hi || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), i, j, par);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(reversed, 0, 0, new char[]{')', '('});
        } else {
            ans.add(reversed);
        }
    }
}