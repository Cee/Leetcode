class Solution {
     public String crackSafe(int n, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append("0");
        }
        Set<String> visited = new HashSet<>();
        visited.add(result.toString());
        crackSafeFrom(result, n, k, (int) Math.pow(k, n), visited);

        return result.toString();
    }

    private boolean crackSafeFrom(StringBuilder result, int n, int k, int total, Set<String> visited) {

        if (visited.size() == total) {
            return true;
        }

        String curNode = result.substring(result.length() - n + 1);

        for (char c = '0'; c < '0' + k; c++) {
            if (!visited.contains(curNode + c)) {
                result.append(c);
                visited.add(curNode + c);
                if (crackSafeFrom(result, n, k, total, visited)) {
                    return true;
                }
                result.deleteCharAt(result.length() - 1);
                visited.remove(curNode + c);
            }
        }
        return false;
    }
}