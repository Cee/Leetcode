class Solution {
    public int mySqrt(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int)r;
    }
}


class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 0; 
        int right = x;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (Math.pow(mid, 2) == x) {
                return mid;
            } else if (Math.pow(mid, 2) < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}