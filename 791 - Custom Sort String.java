class Solution {
    public String customSortString(String S, String T) {
        int[] count = new int[26];
        for (char c: T.toCharArray()) {
            count[c - 'a'] += 1;
        }

        StringBuilder ans = new StringBuilder();

        for (char c: S.toCharArray()) {
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
            count[c - 'a'] = 0;
        }

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < count[c - 'a']; i++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}

class Solution {
    public int[] priorities = new int[26];
    
    public String customSortString(String S, String T) {
        if (S == null || S.length() == 0) { return T; }
        for (int i = 0; i < S.length(); i++) {
            priorities[S.charAt(i) - 'a'] = 26 - i;
        }
        Character[] array = new Character[T.length()];
        int i = 0;
        for (char c: T.toCharArray()) {
            array[i++] = Character.valueOf(c);
        }
        Arrays.sort(array, new CustomCharComparator());
        StringBuilder sb = new StringBuilder();
        for (Character c: array) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    public class CustomCharComparator implements Comparator<Character> {
        public int compare(Character l, Character r) {
            return priorities[r.charValue() - 'a'] - priorities[l.charValue() - 'a'];
        }
    }
}