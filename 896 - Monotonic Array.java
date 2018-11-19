class Solution {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) { return true; }
        int i = 0;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                continue;
            }
            break;
        }
        if (i == A.length - 1) { return true; }
        i = 0;
        for (i = 0; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                continue;
            }
            break;
        }
        if (i == A.length - 1) { return true; }
        return false;
    }
}

class Solution {
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }
}