class Solution {
    Set<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
         res = new HashSet<>();
         findSequence(new ArrayList<>(), 0, nums);
         return new ArrayList<>(res);
    }

    public void findSequence(List<Integer> l, int index, int[] nums) {
        if (l.size() >= 2) {
            res.add(new ArrayList<>(l));
        }
        for (int i = index; i < nums.length; i++) {
            if (l.size() == 0 || l.get(l.size() - 1) <= nums[i]) {
                l.add(nums[i]);
                findSequence(l, i + 1, nums);
                l.remove(l.size() - 1);
            }
        }
    }
}