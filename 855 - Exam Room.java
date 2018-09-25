class ExamRoom {

    TreeSet<Integer> set;
    int max;
    public ExamRoom(int N) {
        set = new TreeSet<>();
        max = N;
    }
    
    public int seat() {
        int best = 0;
        if (set.size() > 0) {
            int dist = set.first();
            Integer prev = null;
            for (Integer s: set) {
                if (prev != null) {
                    int d = (s - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        best = prev + d;
                    }
                }
                prev = s;
            }
            
            if (max - 1 - set.last() > dist)
                best = max - 1;
        }
        
        set.add(best);
        return best;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */