// n = k^m + k^(m-1) + ... + k + 1
// => n-1 = k (k^(m-1) + k^(m-2) + ... + k + 1) ...... [1]
// => n-k^m = k^(m-1) + k^(m-2) + ... + k + 1 ...... [2]
// (k^(m+1) - 1)/(k - 1) = n
// Thus ⌊m-th root of n⌋ is the only candidate that needs to be tested. 

class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        
        for (int m = (int)(Math.log(num + 1) / Math.log(2)); m > 2; m--) {
            long l = (long)(Math.pow(num + 1, 1.0 / m));
            long r = (long)(Math.pow(num, 1.0 / (m - 1)));

            while (l <= r) {
                long k = l + ((r - l) >> 1);
                long f = 0L;
                for (int i = 0; i < m; i++, f = f * k + 1);

                if (num == f) {
                    return String.valueOf(k);
                } else if (num < f) {
                    r = k - 1;
                } else {
                    l = k + 1;
                }
            }
        }

        return String.valueOf(num - 1);
    }
}

import java.math.*;
class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.valueOf(n);
        BigInteger bn = BigInteger.valueOf(num);
        int max_m = (int) (Math.log(num) / Math.log(2));
        for (int m = max_m; m >= 1; m--) {
            BigInteger k = BigInteger.valueOf((long) Math.floor(Math.pow(num, 1.0 / m)));
            BigInteger left = k.pow(m + 1).subtract(BigInteger.ONE);
            BigInteger right = bn.multiply(k.subtract(BigInteger.ONE));
            if (left.equals(right)) {
                return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }
}