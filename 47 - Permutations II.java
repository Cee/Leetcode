class Solution {
    List<List<Integer>> list;
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list = new ArrayList<>();
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), nums);
        return list;
    }
    
    private void backtrack(List<Integer> current, int[] nums){
       if (current.size() == nums.length) {
          list.add(new ArrayList<>(current));
       } else {
          for (int i = 0; i < nums.length; i++) {
              if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                  continue;
              }
              used[i] = true;
              current.add(nums[i]);
              backtrack(current, nums);
              current.remove(current.size() - 1);
              used[i] = false;
          }
       }
    } 
}