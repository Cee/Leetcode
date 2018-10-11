class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) { return true; }
        int i = 0;
        while (i < data.length) {
            int s = data[i];
            int n = (s >> 7) & 1;
            if (n == 0) {
                i += 1;
                continue;
            }
            // start with 1
            n = (s >> 6) & 3;
            if (n != 3) { return false; }
            n = (s >> 3) & 31;
            if (n == 31) { return false; }
            int type = 1;
            n = (s >> 5) & 7;
            if (n == 7) {
                n = (s >> 4) & 15;
                if (n == 15) {
                    type = 3;
                } else {
                    type = 2;
                }
            }
            for (int j = 0; j < type; j++) {
                i += 1;
                if (i >= data.length) { return false; }
                n = (data[i] >> 6) & 3;
                if (n != 2) { return false; }
            }
            i += 1;
        }
        return true;
    }
}