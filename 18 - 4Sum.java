class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int second = 0, third = 0, nexti = 0, nextj = 0;
        for(int i = 0; i < n - 3; i++) {
            if (nums[i] * 4 > target) { return list; } // return immediately
            for (int j = n - 1; j > i + 2; j--) {
                if (nums[j] * 4 < target) { break; }
                int remaining = target - nums[i] - nums[j];
                int lo = i + 1;
                int hi = j - 1;
                while (lo < hi) {
                    int sum = nums[lo] + nums[hi];
                    if (sum > remaining) {
                        hi -= 1;
                    } else if (sum < remaining) {
                        lo += 1;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
                        lo += 1;
                        hi -= 1;
                        while (lo <= hi && nums[lo - 1] == nums[lo]) { lo += 1; } 
                        while (hi >= lo && nums[hi] == nums[hi + 1]) { hi -= 1; } 
                    }
                }
                while (j >= 1 && nums[j] == nums[j - 1]) { j -= 1; }
            }
            while(i < n - 1 && nums[i] == nums[i + 1]) { i += 1; }
        }
        return list;
    }
}