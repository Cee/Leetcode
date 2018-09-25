class Solution {
    class Replace {
        int index;
        String source;
        String target;
        Replace(int i, String s, String t) {
            this.index = i;
            this.source = s;
            this.target = t;
        }
    }
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder sb = new StringBuilder();
        List<Replace> list = new ArrayList<>();
        for (int j = 0; j < indexes.length; j++) {
            list.add(new Replace(indexes[j], sources[j], targets[j]));
        }
        Collections.sort(list, (a, b) -> (a.index - b.index));
        int i = 0;
        for (Replace r: list) {
            int index = r.index;
            String source = r.source;
            String target = r.target;
            while (i < index) {
                sb.append(S.charAt(i));
                i++;
            }
            int k;
            for (k = 0; k < source.length(); k++) {
                if (i + k >= S.length() || source.charAt(k) != S.charAt(i + k)) { break; }
            }
            if (k != source.length()) { continue; }
            sb.append(target);
            i = index + source.length();
        }
        while (i < S.length()) {
            sb.append(S.charAt(i));
            i++;
        }
        return sb.toString();
    }
}