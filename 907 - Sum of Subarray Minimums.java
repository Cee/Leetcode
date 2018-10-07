class Solution {
    public int sumSubarrayMins(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            int num = A[i];
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && A[left] >= A[i]) { left--; }
            while (right < A.length && A[right] > A[i]) { right++; }
            // System.out.println(A[i] + " " + left + " " + right);
            sum = (sum + A[i] * (i - left) * (right - i)) % 1000000007;
        } 
        return sum;
    }
}