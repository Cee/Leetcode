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
    public int minMeetingRooms(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i: intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int min = 0;
        int sum = 0;
        for (int key: map.keySet()) {
            sum += map.get(key);
            min = Math.max(min, sum);
        }
        return min;
    }
}