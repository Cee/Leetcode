class Solution {
    public String[] findWords(String[] words) {
        String s1 = "qwertyuiop";
        String s2 = "asdfghjkl";
        String s3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word: words) {
            int c1 = 0, c2 = 0, c3 = 0;
            int n = word.length();
            for (char c: word.toLowerCase().toCharArray()) {
                if (s1.indexOf(c) >= 0) { c1 += 1; continue; }
                if (s2.indexOf(c) >= 0) { c2 += 1; continue; }
                if (s3.indexOf(c) >= 0) { c3 += 1; continue; }
            }
            if (c1 == n || c2 == n || c3 == n) {
                list.add(word);
            }
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}