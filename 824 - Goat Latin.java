class Solution {
    public String toGoatLatin(String S) {
        if (S == null || S.length() == 0) { return S; }
        Set<Character> set = new HashSet<>();
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        String[] strs = S.split(" ");
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String str = strs[i];
            if (set.contains(str.charAt(0))) {
                for (int j = 0; j < str.length(); j++) { sb.append(str.charAt(j)); }
            } else {
                for (int j = 1; j < str.length(); j++) { sb.append(str.charAt(j)); }
                sb.append(str.charAt(0));
            }
            sb.append("ma");
            for (int j = 1; j <= i + 1; j++) { sb.append("a"); }
            if (i != n - 1) { sb.append(" "); }
        }
        return sb.toString();
    }
}