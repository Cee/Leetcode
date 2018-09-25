class Solution {
    List<List<Integer>> list;
    public List<List<Integer>> permute(int[] nums) {
       list = new ArrayList<>();
       backtrack(new ArrayList<>(), nums);
       return list;
    }

    private void backtrack(List<Integer> current, int[] nums){
       if (current.size() == nums.length) {
          list.add(new ArrayList<>(current));
       } else {
          for (int num: nums) {
              if (current.contains(num)) {
                  continue;
              }
              current.add(num);
              backtrack(current, nums);
              current.remove(current.size() - 1);
          }
       }
    } 
}