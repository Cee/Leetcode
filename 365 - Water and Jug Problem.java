class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) { return false; }
        if (x == z || y == z || x + y == z) { return true; }
        return gcd(x, y) == 0 ? false : z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        if (x < y) { int temp = x; x = y; y = temp; }
        if (y == 0) { return 0; }
        while (x % y != 0) {
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }
}