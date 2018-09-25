class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) { return 0; }
        Stack<Integer> nums = new Stack<>();
        Stack<Character> ops = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c: s.toCharArray()) {
            if (c == ' ') { continue; }
            if (c == '*' || c == '/' || c == '+' || c == '-') {
                nums.push(Integer.valueOf(sb.toString()));
                sb = new StringBuilder();
                if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    char op = ops.pop();
                    int b = nums.pop();
                    int a = nums.pop();
                    if (op == '*') { nums.push(a * b); }
                    if (op == '/') { nums.push(a / b); }
                }
                ops.push(c);
            }
            if (c >= '0' && c <= '9') { sb.append(c); }
        }
        if (sb.length() != 0) { nums.push(Integer.valueOf(sb.toString())); }
        if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
            char op = ops.pop();
            int b = nums.pop();
            int a = nums.pop();
            if (op == '*') { nums.push(a * b); }
            if (op == '/') { nums.push(a / b); }
        }
        int sum = 0;
        while (!ops.isEmpty()) {
            char op = ops.pop();
            int a = nums.pop();
            if (op == '+') { sum += a; }
            if (op == '-') { sum -= a; }
        }
        if (!nums.isEmpty()) { sum += nums.pop(); }
        return sum;
    }
}