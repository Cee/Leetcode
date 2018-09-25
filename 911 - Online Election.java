class TopVotedCandidate {
    int[] persons;
    int[] times;
    TreeMap<Integer, Integer> map;
    Map<Integer, Integer> votes;
    int timestamp;
    
    int candidate;
    int max;
    int prevT;
    int i;
    public TopVotedCandidate(int[] persons, int[] times) {
        map = new TreeMap<>();
        votes = new HashMap<>();
        this.persons = persons;
        this.times = times;
        
        timestamp = times[0];
        
        candidate = persons[0];
        max = 1;
        votes.put(candidate, 1);
        prevT = times[0];
        i = 1;
        map.put(times[0], candidate);
    }
    
    private void handle(int t) {
        if (t < timestamp) { return; }
        
        while (i < times.length) {
            if (times[i] > t) {
                timestamp = times[i];
                break;
            }
            timestamp = times[i];
            while (i < times.length && prevT == times[i]) {
                int person = persons[i];
                if (candidate == person) {
                    max += 1;
                    votes.put(candidate, max);
                } else {
                    int v = votes.getOrDefault(person, 0) + 1;
                    if (v >= max) {
                        candidate = person;
                        max = v;
                    }
                    votes.put(person, v);
                }
                i++;
            }
            map.put(prevT, candidate);
            if (i < times.length) {
                prevT = times[i];
            }
        }
        
    }
    public int q(int t) {
        handle(t);
        if (map.containsKey(t)) { return map.get(t); }
        return (map.get(map.lowerKey(t)));
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */