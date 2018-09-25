class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int[] secretNums = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a += 1;
            } else {
                secretNums[secret.charAt(i) - '0'] += 1;
            }
        }
        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i) && secretNums[guess.charAt(i) - '0'] > 0) {
                b += 1;
                secretNums[guess.charAt(i) - '0'] -= 1;
            }
        }
        return a + "A" + b + "B";
    }
}