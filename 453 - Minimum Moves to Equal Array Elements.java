class Solution {
    public int minMoves(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int sum = 0; 
        int min = Integer.MAX_VALUE;
        for (int num: nums) { 
            sum += num; 
            min = Math.min(min, num);
        }
        return sum - nums.length * min;
    }
}