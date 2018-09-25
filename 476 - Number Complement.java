class Solution {
    public int findComplement(int num) {
        int ans = 1;
        while (ans - 1 < num) {
            ans <<= 1;
        }
        return ans - 1 - num;
    }
}