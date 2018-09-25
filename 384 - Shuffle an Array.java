import java.util.Random;
class Solution {

    int[] ori;
    Random r;
    public Solution(int[] nums) {
        ori = nums.clone();
        r = new Random(System.currentTimeMillis());
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return ori;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] ans = ori.clone();
        for (int i = 0; i < ans.length; i++) {
            swap(ans, i, r.nextInt(ans.length));
        }
        return ans;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */