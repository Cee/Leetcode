// To choose a word, calculate a matrix counting the number of words where each char is in each position. Then score each word by adding the number of words that have the same chars in the same positions.
/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Set<String> set = new HashSet<>();
        for (String s: wordlist) { set.add(s); }
        
        while (!set.isEmpty()) {
            String s = mostOverlapWord(set);
            int matches = master.guess(s);
            if (matches == 6) {
                return;
            }
            Set<String> newSet = new HashSet<>();
            for (String word: set) {
                if (matches(word, s) == matches) {
                    newSet.add(word);
                }
            }
            set = newSet;
        }
    }
    
    private String mostOverlapWord(Set<String> candidates) {
        int[][] counts = new int[6][26];
        for (String s: candidates) {
            for (int i = 0; i < s.length(); i++) {
                counts[i][s.charAt(i) - 'a'] += 1;
            }
        }
        
        int max = 0;
        String overlap = "";
        for (String s: candidates) {
            int score = 0;
            for (int i = 0; i < s.length(); i++) {
                score += counts[i][s.charAt(i) - 'a'];
            }
            if (score > max) {
                max = score;
                overlap = s;
            } 
        }
        return overlap;
    }
    
    private int matches(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}