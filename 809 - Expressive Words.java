class Solution {
    class Group {
        char c;
        int count;
        Group(char ch, int cnt) { c = ch; count = cnt; }
    }
    
    private List<Group> representation(String s) {
        List<Group> rep = new ArrayList<>();
        if (s == null || s.length() == 0) { return rep; }
        int n = s.length();
        int i = 0;
        while (i < n) {
            int count = 0;
            int lo = i;
            while (i < n && s.charAt(i) == s.charAt(lo)) {
                i++;
                count++;
            }
            rep.add(new Group(s.charAt(lo), count));
            // System.out.println(s.charAt(lo) + " " + count);
        }
        return rep;
    }    
    public int expressiveWords(String S, String[] words) {
        List<Group> repS = representation(S);
        
        int ans = 0;
        for (String word: words) {
            if (word.length() > S.length()) { continue; }
            if (word.length() == S.length()) {
                if (word.equals(S)) {
                    ans += 1;
                }
                continue;
            }
            List<Group> repW = representation(word);
            if (repW.size() != repS.size()) { continue; }
            boolean same = true;
            for (int i = 0; i < repW.size(); i++) {
                Group w = repW.get(i);
                Group s = repS.get(i);
                System.out.println(w.c);
                if (w.c != s.c) { same = false; break; }
                if (w.count > s.count) { same = false; break; }
                if (w.count == s.count) { continue; }
                if (s.count <= 2) {
                    if (w.count != s.count) { same = false; break; }
                } 
                // else {
                    // if (s.count - w.count == 1) { same = false; break; }
                // }
            }
            ans += same ? 1 : 0;
            // if (same) { System.out.println(word); }
        }
        return ans;
    }
}