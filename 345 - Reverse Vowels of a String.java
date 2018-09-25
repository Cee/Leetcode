class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('A');
        vowels.add('e');vowels.add('E');
        vowels.add('i');vowels.add('I');
        vowels.add('o');vowels.add('O');
        vowels.add('u');vowels.add('U');
        
        int i = 0;
        int j = s.length() - 1;
        char[] chars = s.toCharArray();
        while (i < j) {
            while (i < j && !vowels.contains(chars[i])) {
                i++;
            }
            while (i < j && !vowels.contains(chars[j])) {
                j--;
            }
            swap(chars, i, j);
            i++;
            j--;
        }
        return new String(chars);
    }
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}