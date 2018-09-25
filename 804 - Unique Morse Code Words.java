class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mapping = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Set<String> set = new HashSet<>();
        for (String word: words) {
            String s = new String();
            for (char c: word.toCharArray()) {
                s = s + mapping[c - 'a'];
            }
            set.add(s);
        }
        
        return set.size();
    }
}