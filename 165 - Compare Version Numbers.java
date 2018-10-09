class Solution {
    public int compareVersion(String version1, String version2) {
        // Assume correctness
        String[] split1 = version1.split("\\.", -1);
        String[] split2 = version2.split("\\.", -1);
        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            int v1 = (i >= split1.length) ? 0 : Integer.valueOf(split1[i]);
            int v2 = (i >= split2.length) ? 0 : Integer.valueOf(split2[i]);
            if (v1 > v2) {
                return 1;
            } else if (v1 < v2) {
                return -1;
            }
        }
        return 0;
    }
}