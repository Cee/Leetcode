class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<Integer>> groups = new ArrayList<>();
        List<Integer> lengths = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        int currLen = 0;
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int len = s.length();
            if (currLen + curr.size() + len > maxWidth) {
                groups.add(new ArrayList<>(curr));
                lengths.add(currLen);
                curr = new ArrayList<>();
                currLen = 0;
            }
            currLen += len;
            curr.add(i);
        }
        if (currLen > 0) { 
            groups.add(new ArrayList<>(curr));
            lengths.add(currLen);
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < groups.size(); i++) {
            List<Integer> group = groups.get(i);
            int len = lengths.get(i);
            StringBuilder sb = new StringBuilder();
            if (group.size() == 1) {
                // Case 1: one word
                sb.append(words[group.get(0)]);
                for (int j = len + 1; j <= maxWidth; j++) { sb.append(" "); }
            } else if (i == groups.size() - 1) {
                // Case 2: last line
                for (int j = 0; j < group.size(); j++) {
                    sb.append(words[group.get(j)]);
                    if (j != group.size() - 1) { sb.append(" "); }
                }
                for (int j = len + group.size(); j <= maxWidth; j++) { sb.append(" "); }
            } else {
                int spaces = maxWidth - len;
                int intervals = group.size() - 1;
                for (int j = 0; j < group.size(); j++) {
                    sb.append(words[group.get(j)]);
                    if (j != group.size() - 1) {
                        for (int k = 1; k <= spaces / intervals; k++) { sb.append(" "); }
                        if (j < spaces % intervals) { sb.append(" "); }
                    }
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }
}