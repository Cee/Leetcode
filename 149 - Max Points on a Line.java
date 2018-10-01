/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) { return 0; }
        if (points.length <= 2) { return points.length; }
        
        int ans = 0;
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap += 1;
                    continue;
                }
                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }
                if (!map.containsKey(x)) {
                    map.put(x, new HashMap<>());
                }
                map.get(x).put(y, map.get(x).getOrDefault(y, 0) + 1);
                max = Math.max(max, map.get(x).get(y));
            }
            ans = Math.max(ans, max + overlap + 1);
        }
        return ans;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) { return a; }
        return gcd(b, a % b);
    }
}