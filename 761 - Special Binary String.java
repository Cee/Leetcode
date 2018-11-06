class Solution {
    public String makeLargestSpecial(String S) {
        if (S.length() == 0) { return S; }
        int anchor = 0, bal = 0;
        List<String> mountains = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            if (S.charAt(i) == '1') {
                bal += 1;
            } else {
                bal -= 1;
            }
            if (bal == 0) {
                mountains.add("1" + makeLargestSpecial(S.substring(anchor + 1, i)) + "0");
                anchor = i + 1;
            }
        }
        Collections.sort(mountains, Collections.reverseOrder());
        StringBuilder ans = new StringBuilder();
        for (String mountain: mountains) {
            ans.append(mountain);
        }
        return ans.toString();
    }
}