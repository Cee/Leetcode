class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) { return list; }
        Arrays.sort(nums);
        for (int i = 0; i <= nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (sum == 0) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[lo]);
                    l.add(nums[hi]);
                    list.add(l);
                    while (lo < hi && lo + 1 < nums.length && nums[lo + 1] == nums[lo]) {
                        lo++;
                    }
                    while (lo < hi && hi - 1 >= 0 && nums[hi - 1] == nums[hi]) {
                        hi--;
                    }
                    lo++;
                    hi--;
                } else if (sum < 0) {
                    lo++;
                } else {
                    hi--;
                }
            }
        }
        return list;
    }
}