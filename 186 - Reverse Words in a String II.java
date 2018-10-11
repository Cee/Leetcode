class Solution {
    public void reverseWords(char[] str) {
        if (str == null || str.length == 0) { return; }
        int n = str.length;
        swap(str, 0, n - 1);
        int lo = 0;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || str[i + 1] == ' ') {
                swap(str, lo, i);
                lo = i + 2;
            }
        }
    }
    
    private void swap(char[] str, int i, int j) {
        while (i < j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }
}