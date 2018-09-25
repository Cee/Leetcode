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
    public List<Interval> merge(List<Interval> intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i: intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        
        List<Interval> list = new ArrayList<>();
        int sum = 0;
        int start = 0;
        for (int key: map.keySet()) {
            if (sum == 0) {
                start = key;
            }    
            sum += map.get(key);
            if (sum == 0) {
                list.add(new Interval(start, key));
            }
        }
        return list;
    }
}