class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) { return ans; }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.offer("");
        for (char digit: digits.toCharArray()) {
            int x = digit - '0';
            int size = ans.size();
            while (size > 0) {
                String s = ans.poll();
                for (char c: mapping[x].toCharArray()) {
                    ans.offer(s + c);
                }
                size -= 1;
            }
        }
        return ans;
    }
}