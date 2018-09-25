/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i: intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int sum = 0;
        for (int key: map.keySet()) {
            int value = map.get(key);
            if (value == 0) { continue; }
            if (Math.abs(value) != 1) { return false; }
            if (sum == 0) {
                sum += value;
            } else {
                sum += value;
                if (sum != 0) { return false; }
            }
        }
        return true;
    }
}