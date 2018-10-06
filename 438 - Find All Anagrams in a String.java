class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        Set<Character> set = new HashSet<>();
        for (char c: p.toCharArray()) {
            count[c - 'a'] += 1;
            set.add(c);
        }
        List<Integer> ans = new ArrayList<>();
        int l = p.length();
        int lo = 0;
        int hi = 0;
        while (hi < s.length()) {
            if (hi < l) {
                count[s.charAt(hi) - 'a'] -= 1;
                hi++;
            } else {
                boolean isAnagram = true;
                for (char c: set) {
                    if (count[c - 'a'] != 0) {
                        isAnagram = false;
                        break;
                    }                    
                }
                if (isAnagram) { ans.add(lo); }
                count[s.charAt(lo) - 'a'] += 1;
                lo++;
                count[s.charAt(hi) - 'a'] -= 1;
                hi++;
            }
        }
        boolean isAnagram = true;
        for (char c: set) {
            if (count[c - 'a'] != 0) {
                isAnagram = false;
                break;
            }                    
        }
        if (isAnagram) { ans.add(lo); }
        return ans;
    }
}