/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            int result = guess(mi);
            if (result == 0) { return mi; }
            if (result == -1) {
                hi = mi - 1;
            } else {
                lo = mi + 1;
            }
        }
        return lo;
    }
}