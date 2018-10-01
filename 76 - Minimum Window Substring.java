// Use intValue() for comparison
class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) { return ""; }

        Map<Character, Integer> dictT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            dictT.put(c, dictT.getOrDefault(c, 0) + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;

        Map<Character, Integer> windowCounts = new HashMap<>();

        // ans list of the form (window length, left, right)
        int length = -1;
        int start = 0;
        int end = 0;

        while (r < s.length()) {
          char c = s.charAt(r);
          windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

          if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
              formed++;
          }

          while (l <= r && formed == required) {
              c = s.charAt(l);
              
              if (length == -1 || r - l + 1 < length) {
                  length = r - l + 1;
                  start = l;
                  end = r;
              }

              windowCounts.put(c, windowCounts.get(c) - 1);
              if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                  formed--;
              }

              l++;
          }

          r++;   
        }

        return length == -1 ? "" : s.substring(start, end + 1);
    }
}