class Solution {
    public String nextClosestTime(String time) {
        int start = 60 * Integer.parseInt(time.substring(0, 2));
        start += Integer.parseInt(time.substring(3));
        int ans = start;
        int elapsed = 24 * 60;
        Set<Integer> allowed = new HashSet();
        for (char c: time.toCharArray()) if (c != ':') {
            allowed.add(c - '0');
        }

        for (int h1: allowed) for (int h2: allowed) if (h1 * 10 + h2 < 24) {
            for (int m1: allowed) for (int m2: allowed) if (m1 * 10 + m2 < 60) {
                int cur = 60 * (h1 * 10 + h2) + (m1 * 10 + m2);
                int candElapsed = Math.floorMod(cur - start, 24 * 60);
                if (0 < candElapsed && candElapsed < elapsed) {
                    ans = cur;
                    elapsed = candElapsed;
                }
            }
        }

        return String.format("%02d:%02d", ans / 60, ans % 60);
    }

    public String previousClosestTime(String time) {
        int startTime = 60 * Integer.parseInt(time.substring(0, 2)) + 
                         1 * Integer.parseInt(time.substring(3));
        
        Set<Integer> digits = new HashSet<>();
        for (char c: time.toCharArray()) {
            if (c != ':') {
                digits.add(c - '0');
            }
        }

        int day = 60 * 24;
        int ans = startTime;
        int minInterval = day;

        for (int h1: digits) {
            for (int h2: digits) {
                int hour = 10 * h1 + h2;
                if (hour < 24) {
                    for (int m1: digits) {
                        for (int m2: digits) {
                            int minute = 10 * m1 + m2;
                            if (minute < 60) {
                                int previousTime = 60 * hour + minute;
                                int interval = Math.floorMod(startTime - previousTime, day);
                                if (0 < interval && interval < minInterval) {
                                    ans = previousTime;
                                    minInterval = interval;
                                }
                            }
                        }
                    }
                }
            }
        }

        return String.format("%02d:%02d", ans / 60, ans % 60);
    }
}