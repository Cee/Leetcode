class Result {

    /*
     * Complete the 'findSubstrings' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void findSubstrings(String s) {
    // Write your code here
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        String min = "";
        String max = "";
        
        int n = s.length();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (!vowels.contains(sArray[i])) { continue; }
            
            StringBuilder sb = new StringBuilder();
            sb.append(sArray[i]);
            for (int j = i + 1; j < n; j++) {
                sb.append(sArray[j]);
                if (vowels.contains(sArray[j])) { 
                    continue; 
                }
                String str = sb.toString();
                if (min.equals("") || min.compareTo(str) > 0) {
                    min = str;
                }
                break;
            }
            
            sb = new StringBuilder(s.substring(i));
            for (int j = n - 1; j > i; j--) {
                if (vowels.contains(sArray[j])) {
                    sb.deleteCharAt(sb.length() - 1);
                    continue; 
                }
                String str = sb.toString();
                if (max.equals("") || max.compareTo(str) < 0) {
                    max = str;
                }
                break;
            }
        }
        
        System.out.println(min);
        System.out.println(max);
    }

}


