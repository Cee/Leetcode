class Solution {
//     public int divide(int dividend, int divisor) {
//         if (divisor == 0) {
//              return dividend >= 0? Integer.MAX_VALUE : Integer.MIN_VALUE;
//         }
        
//         if (dividend == 0) {
//             return 0;
//         }
        
//         if (dividend == Integer.MIN_VALUE && divisor == -1) {
//             return Integer.MAX_VALUE;
//         }
        
//         boolean isNegative = (dividend < 0 && divisor > 0) || 
//                              (dividend > 0 && divisor < 0);
                             
//         long a = Math.abs((long)dividend);
//         long b = Math.abs((long)divisor);
//         int result = 0;
//         while (a >= b) {
//             int shift = 0;
//             while (a >= (b << shift)) {
//                 shift++;
//             }
//             a -= b << (shift - 1);
//             result += 1 << (shift - 1);
//         }
//         return isNegative? -result: result;
//     }

    // for example, if we want to calc (17/2)
    // ret = 0;
    // 17-2 ,ret+=1; left=15
    // 15-4 ,ret+=2; left=11
    // 11-8 ,ret+=4; left=3
    // 3-2 ,ret+=1; left=1
    // ret=8;
    public int divide(int dividend, int divisor) {
        //check if negative answer
        boolean isNeg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        
        //use long to take care of overflow
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        
        long res = 0, curr = 1;
        long sub = ldivisor;
        
        while (ldividend >= ldivisor) {
            if (ldividend >= sub) {
                res += curr;
                ldividend -= sub;
                sub = sub << 1; //sub = sub * 2
                curr = curr << 1; //curr = curr * 2
            }
            else {
                sub = sub >> 1;
                curr = curr >> 1;
            }
        }
        
        res = isNeg ? -res : res;
        
        return (int) (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? Integer.MAX_VALUE : res);
    }
}