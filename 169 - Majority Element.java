class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        for (int num: nums) {
            if (num == majority) {
                count += 1;
            } else {
                count -= 1;
                if (count < 0) {
                    majority = num;
                    count = 1;
                }
            }
        }
        return majority;
    }
}