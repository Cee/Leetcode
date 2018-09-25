class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();
        int index = 0;
        long j = lower;
        while (index < nums.length) {
            int i = nums[index];
            if (i == j) {
                index += 1;
                j += 1;
                continue;
            } else if (i - j == 1) {
                list.add(String.valueOf(j));
                j = i;
            } else if (i - j > 1) {
                list.add(j + "->" + String.valueOf(i - 1));
                index += 1;
                j = i;
                j += 1;
            } else {
                index += 1;
            }
        }
        if (j <= upper) {
            if (upper == j) {
                list.add(String.valueOf(j));
            } else {
                list.add(j + "->" + String.valueOf(upper));
            }
        }
        return list;
    }
}