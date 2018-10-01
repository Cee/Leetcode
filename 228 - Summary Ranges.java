class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) { return ans; }
        if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int n = nums.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j + 1 < n && nums[j] + 1 == nums[j + 1]) { j++; }
            if (i == j) {
                ans.add(String.valueOf(nums[i]));
            } else {
                ans.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
            }
            j += 1;
            i = j;
        }
        
        return ans;
    }
}