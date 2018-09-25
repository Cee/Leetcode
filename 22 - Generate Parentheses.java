class Solution {
    List<String> list;
    public List<String> generateParenthesis(int n) {
        list = new ArrayList();
        backtrack("", 0, 0, n);
        return list;
    }

    public void backtrack(String cur, int open, int close, int max){
        if (open + close == max * 2) {
            list.add(cur);
            return;
        }

        if (open < max)
            backtrack(cur + "(", open + 1, close, max);
        if (close < open)
            backtrack(cur + ")", open, close + 1, max);
    }
}