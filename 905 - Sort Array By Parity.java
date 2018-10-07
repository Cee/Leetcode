class Solution {
    public int[] sortArrayByParity(int[] A) {
        int[] ans = new int[A.length];
        int i = 0;
        int j = A.length - 1;
        for (int n: A) {
            if (n % 2 == 0) {
                ans[i] = n;
                i++;
            } else {
                ans[j] = n;
                j--;
            }
        }
        return ans;
    }
}