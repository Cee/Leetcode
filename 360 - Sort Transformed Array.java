class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num: nums) {
            int x = quad(num, a, b, c);
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = map.firstEntry().getKey();
            if (map.firstEntry().getValue() == 1) {
                map.remove(map.firstEntry().getKey());
            } else {
                map.put(map.firstEntry().getKey(), map.firstEntry().getValue() - 1);
            }
        }
        return ans;
    }
    
    private int quad(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}

class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if (nums.length == 0 || nums == null)
            return new int[0];
        int n = nums.length;
        int[] res = new int[n];
        if (a == 0) {
            for (int i = 0; i < n; i++) {
                int cur = b >= 0 ? nums[i] : nums[n - 1 - i];
                res[i] = b * cur + c;
            }
            return res;
        }
        //sort based on distance to pivot
        double pivot = (double) -b / (2 * a);
        int[] distSorted = new int[n];
        int lo = 0, hi = n - 1, end = n - 1;
        while (lo <= hi) { 
            double d1 = pivot - nums[lo], d2 = nums[hi] - pivot;
            if (d1 > d2) {
                distSorted[end--] = nums[lo++];
            } else {
                distSorted[end--] = nums[hi--];
            }
        }
        //populate res based on distSorted, and also a
        for (int i = 0; i < n; i++) {
            int cur = a > 0 ? distSorted[i] : distSorted[n - 1 - i];
            res[i] = a * cur * cur + b * cur + c;
        }
        return res;
    }
}