public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int[] bits = new int[32];
        for (int i = 0; i < 32; i++) {
            bits[i] = (n >> i) & 1;
        }
        swap(bits, 0, 31);
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans = ans + ((bits[i] & 1) << i);
        }
        return ans;
    }
    
    private void swap(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}