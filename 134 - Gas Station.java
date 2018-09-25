class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int min = Integer.MAX_VALUE;
        int costs = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            costs += gas[i] - cost[i];
            if (min > costs) {
                min = costs;
                index = i;
            }
        }
        return costs < 0 ? -1 : (index + 1) % gas.length;
    }
}