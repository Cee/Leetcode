class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }
}

class Solution {
    class TrieNode {
        TrieNode[] children;
        TrieNode() { children = new TrieNode[2]; }
    }
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        TrieNode root = new TrieNode();
        for (int num: nums) {
            TrieNode t = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (t.children[bit] == null) {
                    t.children[bit] = new TrieNode();
                }
                t = t.children[bit];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num: nums) {
            TrieNode t = root;
            int sum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >>> i) & 1;
                if (t.children[bit ^ 1] != null) {
                    sum += (1 << i);
                    t = t.children[bit ^ 1];
                } else {
                    t = t.children[bit];
                }
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}