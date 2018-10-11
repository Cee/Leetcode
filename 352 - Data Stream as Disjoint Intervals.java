/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class SummaryRanges {

    TreeMap<Integer, Interval> map;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) { return; }
        Integer lo = map.lowerKey(val);
        Integer hi = map.higherKey(val);
        if (lo != null && hi != null && map.get(lo).end + 1 == val && hi == val + 1) {
            // have 1, 3, insert 2
            // extend
            map.get(lo).end = map.get(hi).end;
            map.remove(hi);
        } else if (lo != null && map.get(lo).end + 1 >= val) {
            // 1 - k, x, x <= k + 1
            map.get(lo).end = Math.max(map.get(lo).end, val);
        } else if (hi != null && hi == val + 1) {
            // 3 - 6, insert 2
            map.put(val, new Interval(val, map.get(hi).end));
            map.remove(hi);
        } else {
            map.put(val, new Interval(val, val));
        }
    }
    
    public List<Interval> getIntervals() {
        return new ArrayList<>(map.values());
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */