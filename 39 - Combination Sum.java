class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) { return ans; }
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }
    
    private void dfs(int[] candidates, int target, int sum, int idx, List<Integer> l) {
        if (target == sum) {
            ans.add(l);
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] <= target) {
                List<Integer> newList = new ArrayList<>(l);
                newList.add(candidates[i]);
                dfs(candidates, target, sum + candidates[i], i, newList);
            }
        }
    }
}