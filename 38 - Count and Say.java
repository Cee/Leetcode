class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        } else if (n == 3) {
            return "21";
        } else {
            String s = countAndSay(n - 1);
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            
            int count = 1;
            char curr = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == curr) {
                    count += 1;
                } else {
                    sb.append(String.valueOf(count));
                    sb.append(curr);
                    curr = arr[i];
                    count = 1;
                }
            }
            sb.append(String.valueOf(count));
            sb.append(curr);
            return sb.toString();
        }
    }
}