class Solution {
    
    int min;
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (price == null || price.size() == 0) { return 0; }
        int n = price.size();
        int[] p = new int[n];
        int[] amount = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = price.get(i);
            amount[i] = needs.get(i);
        }
        min = Integer.MAX_VALUE;
        dfs(p, special, amount, 0, special.size(), 0);
        return min;
    }
    
    private void dfs(int[] p, List<List<Integer>> special, int[] amount, int i, int n, int total) {
        if (i == n) {
            for (int j = 0; j < amount.length; j++) {
                total += amount[j] * p[j];
            }
            if (total < min) {
                min = total;
            }
            return;
        }
        dfs(p, special, amount, i + 1, n, total);
        int[] a = amount.clone();
        List<Integer> offer = special.get(i);
        for (int j = 0; j < offer.size() - 1; j++) {
            if (offer.get(j) > a[j]) {
                return;
            }
            a[j] -= offer.get(j);
        }        
        dfs(p, special, a, i, n, total + offer.get(offer.size() - 1));    
    }
}