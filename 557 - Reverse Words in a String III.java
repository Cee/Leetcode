class Solution {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) { return s; }
        char[] arr = s.toCharArray();
        int n = s.length();
        int i = 0;
        int j = 0;
        while (i < n && j <= n) {
            if (j == n || arr[j] == ' ') {
                if (j - 1 >= 0) {
                    for (int k = 0; k <= (j - 1 - i) / 2; k++) {
                        swap(arr, i + k, j - 1 - k);
                    }
                }
                j += 1;
                i = j;
            } else {
                j += 1;
            }
        }
        return String.valueOf(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}