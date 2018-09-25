class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> bucket = new HashMap<>();
        int maxLength = 0;
        if (k == 0) { return 0; }
        while (end < s.length()) {
            if (bucket.size() < k) {
                if (bucket.containsKey(s.charAt(end))) {
                    bucket.put(s.charAt(end), bucket.get(s.charAt(end)) + 1);
                } else {
                    bucket.put(s.charAt(end), 1);
                }
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                }
                end++;
            } else if (bucket.size() == k) {
                if (bucket.containsKey(s.charAt(end))) {
                    bucket.put(s.charAt(end), bucket.get(s.charAt(end)) + 1);
                    if (end - start + 1 > maxLength) {
                        maxLength = end - start + 1;
                    }
                    end++;
                } else {
                    while (bucket.size() == k && start < end) {
                        if (bucket.get(s.charAt(start)) == 1) {
                            bucket.remove(s.charAt(start));
                        } else {
                            bucket.put(s.charAt(start), bucket.get(s.charAt(start)) - 1);
                        }
                        start++;
                    }
                }
            }
           
        }
        return maxLength;
    }
}