class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() == 0) { return s; }
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            swap(arr, i, n - 1 - i);
        }
        return String.valueOf(arr);
    }
    
    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}