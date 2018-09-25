class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        
        int n = S.length();
        int remaining = n % K;
        
        if (remaining == 0) {
            remaining = K;
        }
        
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (remaining == 0) {
                sb.append("-");
                remaining = K;
            }
            sb.append(c);
            remaining -= 1;
        }
        return sb.toString();
    }
}