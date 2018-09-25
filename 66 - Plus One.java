class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }
        if (carry == 0) {
            return digits;
        } else {
            int[] arr = new int[n + 1];
            arr[0] = carry;
            for (int i = 0; i < n; i++) {
                arr[i + 1] = digits[i];
            }
            return arr;
        }
    }
}