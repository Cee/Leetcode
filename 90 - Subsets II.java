class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    private void backtrack(List<Integer> current, int[] nums, int lo) {
        list.add(new ArrayList<>(current));
        for (int i = lo; i < nums.length; i++) {
            if (i > lo && nums[i] == nums[i - 1]) { continue; }
            current.add(nums[i]);
            backtrack(current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }
}