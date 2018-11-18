class Solution {
    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int[] maxLens = new int[nums.length];// length of longest increasing sequence start from i
        int[] counts = new int[nums.length]; // number of length of longest increasing sequence start from i
        int maxLen = 1; // length of longest increasing subsequnce
        maxLens[nums.length - 1] = 1;
        counts[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {//Backward iteration, i is used as the first character
            int curMax = 1;
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {//j is used as the second character
                if (nums[i] < nums[j]) {//increasing number
                    if (curMax == maxLens[j] + 1) {//means have another way to reach the same max length increasing sequence
                        count += counts[j];  //Important: not ++
                    } else if (curMax < maxLens[j] + 1) {
                        count = counts[j]; 
                        curMax = maxLens[j] + 1; 
                    }
                }
            }
            maxLens[i] = curMax;
            counts[i] = count;
            maxLen = Math.max(maxLen, curMax);
        }
        int count = 0;
        for (int i = 0; i< maxLens.length; i++) {//check each possible start position
            if (maxLens[i] == maxLen)
                count += counts[i];
        }
        return count;
    }
}