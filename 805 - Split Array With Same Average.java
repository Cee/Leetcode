class Solution {
    public boolean splitArraySameAverage(int[] A) {
        int sum = 0;
        for (int i: A) {
            sum += i;
        }
        
        int n = A.length;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0) {
                set.add(i);
            }
        }
        if (set.isEmpty()) {
            return false;
        }
        
        List<Set<Integer>> ls = new ArrayList<>();
        for (int i = 0; i <= n / 2; i++) {
            ls.add(new HashSet<>());
        }
        ls.get(0).add(0);
        
        for (int num: A) {
            for (int i = ls.size() - 1; i > 0; i--) {
                Set<Integer> pre = ls.get(i - 1);
                if (!pre.isEmpty()) {
                    Set<Integer> cur = ls.get(i);
                    for (int s: pre) {
                        cur.add(s + num);
                    }
                }
            }
        }

        for (int i: set) {
            if (ls.get(i).contains(sum * i / n)) return true;
        }
        return false;
    }
}