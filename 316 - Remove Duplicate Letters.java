class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        int[] count = new int[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] += 1;
        }
        boolean[] visited = new boolean[26];
        for (char c: s.toCharArray()) {
            count[c - 'a'] -= 1;
            if (visited[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && 
                   stack.peek() > c && count[stack.peek() - 'a'] > 0) {
                visited[stack.peek() - 'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char c: stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}