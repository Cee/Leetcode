public class Solution {
    public String reverseWords(String s) {
        if (s == null) { return s; }
        s = s.trim();
        if (s.length() == 0) { return s; }
        char[] arr = s.toCharArray();
        reverse(arr, 0, arr.length - 1);
        int lo = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1 < arr.length && arr[i + 1] == ' ') || (i + 1 == arr.length)) {
                reverse(arr, lo, i);
                lo = i + 2;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (char c: arr) {
            if (c != ' ') { 
                flag = false; 
            } else {
                if (flag) { continue; }
                flag = true;
            }
            sb.append(c);
        }
        return sb.toString();
    }
    
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}