class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        if (num == null || num.length() == 0) { return ans; }
        helper("", num, target, 0, 0, 0);
        return ans;
    }
    
    private void helper(String path, String num, int target, int pos, long eval, long mult) {
        if (pos == num.length()) {
            if (target == eval) {
                ans.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            if (i != pos && num.charAt(pos) == '0') { break; }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            if (pos == 0) {
                helper(path + cur, num, target, i + 1, cur, cur);
            } else {
                helper(path + "+" + cur, num, target, i + 1, eval + cur, cur);
                helper(path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                helper(path + "*" + cur, num, target, i + 1, eval - mult + mult * cur, mult * cur);
            }
        }
    }
}