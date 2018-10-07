class Solution {
    public int totalFruit(int[] tree) {
        int start = 0;
        int end = 0;
        HashMap<Integer, Integer> bucket = new HashMap<>();
        int maxLength = 0;
        while (end < tree.length) {
            if (bucket.size() < 2) {
                if (bucket.containsKey(tree[end])) {
                    bucket.put(tree[end], bucket.get(tree[end]) + 1);
                } else {
                    bucket.put(tree[end], 1);
                }
                if (end - start + 1 > maxLength) {
                    maxLength = end - start + 1;
                }
                end++;
            } else if (bucket.size() == 2) {
                if (bucket.containsKey(tree[end])) {
                    bucket.put(tree[end], bucket.get(tree[end]) + 1);
                    if (end - start + 1 > maxLength) {
                        maxLength = end - start + 1;
                    }
                    end++;
                } else {
                    while (bucket.size() == 2 && start < end) {
                        if (bucket.get(tree[start]) == 1) {
                            bucket.remove(tree[start]);
                        } else {
                            bucket.put(tree[start], bucket.get(tree[start]) - 1);
                        }
                        start++;
                    }
                }
            }
           
        }
        return maxLength;
    }
}