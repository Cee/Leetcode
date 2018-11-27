class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) { return false; }
        boolean inc = true;
        if (A[0] >= A[1]) { return false; }
        for (int i = 0; i < A.length - 1; i++) {
            if (inc) { 
                if (A[i] < A[i + 1]) { 
                    continue; 
                } else if (A[i] == A[i + 1]) {
                    return false;
                } else {
                    inc = false;
                }
            } else {
                if (A[i] > A[i + 1]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return inc == false;
    }
}