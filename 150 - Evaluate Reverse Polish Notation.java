class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String token: tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int b = nums.pop();
                int a = nums.pop();
                if (token.equals("+")) { nums.push(a + b); }
                if (token.equals("-")) { nums.push(a - b); }
                if (token.equals("*")) { nums.push(a * b); }
                if (token.equals("/")) { nums.push(a / b); }
            } else {
                nums.push(Integer.valueOf(token));
            }
        }
        return nums.isEmpty() ? 0 : nums.pop();
    }
}