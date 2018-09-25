class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                result.append(s.charAt(i));
                continue;
            }
            int j = i;
            while (j < s.length() && bold[j]) j++;
            result.append("<b>" + s.substring(i, j) + "</b>");
            i = j - 1;
        }
        
        return result.toString();
    }
}

// Merge Intervals

class Solution {
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
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
    
    public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<>();
        for (String str: dict) {
        	int index = -1;
        	index = s.indexOf(str, index);
        	while (index != -1) {
        		intervals.add(new Interval(index, index + str.length()));
        		index += 1;
        		index = s.indexOf(str, index);
        	}
        }
        
        intervals = merge(intervals);
        
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for (Interval interval: intervals) {
        	sb.append(s.substring(prev, interval.start));
        	sb.append("<b>");
        	sb.append(s.substring(interval.start, interval.end));
        	sb.append("</b>");
        	prev = interval.end;
        }
        if (prev < s.length()) {
        	sb.append(s.substring(prev));
        }
        return sb.toString();
    }
}