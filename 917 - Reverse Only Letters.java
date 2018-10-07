class Solution {
    public String reverseOnlyLetters(String S) {
        if (S == null || S.length() == 0) { return S; }
        char[] arr = S.toCharArray();
        int i = 0;
        int j = S.length() - 1;
        while (i < j) {
            while (i < j && !((arr[i] >= 'a' && arr[i] <= 'z') || (arr[i] >= 'A' && arr[i] <= 'Z'))) { i++; }
            while (i < j && !((arr[j] >= 'a' && arr[j] <= 'z') || (arr[j] >= 'A' && arr[j] <= 'Z'))) { j--; }
            if (i < j) {
                swap(arr, i, j);
                i++;
                j--;
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